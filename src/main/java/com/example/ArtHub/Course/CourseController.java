package com.example.ArtHub.Course;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.Section.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController implements InterfaceOfCourseController {

    @Autowired
    CourseService courseService;
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    SectionService sectionService;

    public List<Section> getSectionList() {
        List<Section> sectionList = sectionRepository.findAll();
        return sectionList;
    }

    public  ResponeCourseDTO fromCourseToResponeCourseDTO(Course course) {
        ResponeCourseDTO courseDTO = new ResponeCourseDTO();
        courseDTO.setCourse_name(course.getCourse_name());
        courseDTO.setCourse_description(course.getCourse_description());
        courseDTO.setCourse_price(course.getCourse_price());
        courseDTO.setCourse_coupon(course.getCourse_coupon());
        courseDTO.setCourse_id(course.getCourse_id());
        courseDTO.setCourse_language(course.getCourse_language());
        courseDTO.setCourse_level(course.getCourse_level());
        courseDTO.setAccount_id(course.getAccount_id());
        courseDTO.setCategory_id(course.getCategory_id());
        courseDTO.setIs_approved(course.getIs_approved());
        courseDTO.setIs_passed(course.isIs_passed());
        courseDTO.setCourse_introduction(course.getCourse_introduction());
        List<ResponeSectionDTO> responeSectionDTOList = ResponeSectionDTO.fromSectionListToResponeSectionDTOList(sectionService.getSectionList(Integer.parseInt(course.getCourse_id())));
        courseDTO.setCourseSection(responeSectionDTOList);
        return courseDTO;
    }

    public  List<ResponeCourseDTO> fromCourseListToResponeCourseDTOList(List<Course> CourseList) {
        List<ResponeCourseDTO> ResponeCourseDTOList = new ArrayList<>();
        for (Course course : CourseList) {

            ResponeCourseDTOList.add(fromCourseToResponeCourseDTO(course));
        }
        return ResponeCourseDTOList;
    }

    public List<ResponeCourseDTO> getCourseList() {
        List<Course> courseListFromDB = courseRepository.findAll();
        ResponeCourseDTO responeCourseDTO = new ResponeCourseDTO();
        List<ResponeCourseDTO> responeCourseDTOList = fromCourseListToResponeCourseDTOList(courseListFromDB);
        return responeCourseDTOList;
    }

    @Override
    public ResponeCourseDTO createCourse(CreateCourseDTO dto) throws AppServiceExeption, IOException {
        Course cousre = courseService.createCourse(dto);
        List<CreateSectionDTO> Sections = dto.getSections();
        for (CreateSectionDTO CreatesectionDTO: Sections) {
            sectionService.createSection(CreatesectionDTO);
        }
        ResponeCourseDTO responeCourseDTO = new ResponeCourseDTO();
        return fromCourseToResponeCourseDTO(cousre);
    }
    @Override
    public List<ResponeCourseDTO> getCourses() {
        List<ResponeCourseDTO> courseList =  getCourseList();
        return courseList;
    }
}

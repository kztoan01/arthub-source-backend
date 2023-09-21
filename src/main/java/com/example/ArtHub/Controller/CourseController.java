package com.example.ArtHub.Controller;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateCourseDTO;
import com.example.ArtHub.DTO.CreateSectionDTO;
import com.example.ArtHub.DTO.ResponeCourseDTO;
import com.example.ArtHub.DTO.ResponeSectionDTO;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Repository.CourseRepository;
import com.example.ArtHub.Service.CourseService;
import com.example.ArtHub.Service.SectionService;
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
    SectionService sectionService;



    public  List<ResponeCourseDTO> fromCourseListToResponeCourseDTOList(List<Course> CourseList) { //This fucntion use to convert courseList into ResponeCourseDTO list
        List<ResponeCourseDTO> ResponeCourseDTOList = new ArrayList<>();
        for (Course course : CourseList) {

            ResponeCourseDTOList.add(fromCourseToResponeCourseDTO(course));
        }
        return ResponeCourseDTOList;
    }

    public List<ResponeCourseDTO> getCourseList() {
        List<Course> courseListFromDB = courseRepository.findAll();
        List<ResponeCourseDTO> responeCourseDTOList = fromCourseListToResponeCourseDTOList(courseListFromDB);
        return responeCourseDTOList;
    }


    public  ResponeCourseDTO fromCourseToResponeCourseDTO(Course course) { //This function use to convert courseEntity to ResponeCourseDTO
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



    @Override
    public ResponeCourseDTO createCourse(CreateCourseDTO dto) throws AppServiceExeption, IOException {
        Course cousre = courseService.createCourse(dto);
        ResponeCourseDTO savedCourse = fromCourseToResponeCourseDTO(cousre);
        List<CreateSectionDTO> Sections = dto.getSections();
        for (CreateSectionDTO CreatesectionDTO: Sections) {
            sectionService.createSection(CreatesectionDTO,Integer.parseInt(savedCourse.getCourse_id()));
        }
        return fromCourseToResponeCourseDTO(cousre);
    }
    @Override
    public List<ResponeCourseDTO> getCourses() {
        List<ResponeCourseDTO> courseList =  getCourseList();
        return courseList;
    }
}

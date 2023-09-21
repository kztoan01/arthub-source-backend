package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateCourseDTO;
import com.example.ArtHub.DTO.ResponeCourseDTO;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService implements InterfaceOfCourseService {

    @Autowired
    CourseRepository courseRepository;





    @Override
    public Course createCourse(CreateCourseDTO dto) throws AppServiceExeption {
        Course course = new Course();
        course.setCourse_coupon(dto.getCourse_coupon());
        course.setCourse_description(dto.getCourse_description());
        course.setCourse_introduction(dto.getCourse_introduction());
        course.setCourse_language(dto.getCourse_language());
        course.setCourse_level(dto.getCourse_level());
        course.setCourse_price(dto.getCourse_price());
        course.setAccount_id(dto.getAccount_id());
        course.setCourse_name(dto.getCourse_name());
        course.setCategory_id(dto.getCategory_id());
        course.setIs_approved(dto.getIs_approved());
        course.setIs_passed(dto.isIs_passed());
        return courseRepository.save(course);
    }

    @Override
    public List<ResponeCourseDTO> getCourseList() {
//        List<Course> courseListFromDB = courseRepository.findAll();
//        ResponeCourseDTO responeCourseDTO = new ResponeCourseDTO();
//        List<ResponeCourseDTO> responeCourseDTOList = courseController.fromCourseListToResponeCourseDTOList(courseListFromDB);
//        return responeCourseDTOList;
        return null;
    }
}

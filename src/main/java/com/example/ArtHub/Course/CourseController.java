package com.example.ArtHub.Course;

import com.example.ArtHub.AppServiceExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class CourseController implements InterfaceOfCourseController {

    @Autowired
    CourseService courseService;
    @Override
    public ResponeCourseDTO createCourse(CreateCourseDTO dto) throws AppServiceExeption, IOException {
        Course cousre = courseService.createCourse(dto);
        return ResponeCourseDTO.fromCourseToResponeCourseDTO(cousre);
    }

    @Override
    public List<ResponeCourseDTO> getCourses() {
        List<Course> courseList =  courseService.getCourseList();
        return ResponeCourseDTO.fromCourseListToResponeCourseDTOList(courseList);
    }
}

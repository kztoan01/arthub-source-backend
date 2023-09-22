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
public class ServiceOfCourse implements InterfaceOfCourseService {

    @Autowired
    CourseRepository courseRepository;





    @Override
    public Course createCourse(CreateCourseDTO dto) throws AppServiceExeption {
        Course course = new Course();
        course.setCoupon(dto.getCoupon());
        course.setDescription(dto.getDescription());
        course.setIntroduction(dto.getIntroduction());
        course.setLanguage(dto.getLanguage());
        course.setLevel(dto.getLevel());
        course.setPrice(dto.getPrice());
        course.setAccountId(dto.getAccountId());
        course.setName(dto.getName());
        course.setApproved(dto.getApproved());
        course.setPassed(dto.isPassed());
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

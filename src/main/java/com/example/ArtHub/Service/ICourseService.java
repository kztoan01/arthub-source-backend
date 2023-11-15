package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateCourseDTO;
import com.example.ArtHub.DTO.ResponeCourseDTO;
import com.example.ArtHub.DTO.ResponeStudentInfor;
import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Entity.Course;

import java.util.List;

public interface ICourseService {
    Course createCourse(CreateCourseDTO dto) throws AppServiceExeption;

//    List<ResponeCourseDTO> getCourseList(CourseRepository courseRepository);


    List<ResponeCourseDTO> getCourseList();



    public int updateMainImage(int id, String imageName);

    public ResponeCourseDTO fromCourseToResponeCourseDTO2(Course course);

    public ResponeStudentInfor fromAccountToResponeStudentDTO(Account account,int courseID);


    public Double getSumPriceCourseByAccountID(int id);


    public  ResponeCourseDTO fromCourseToResponeCourseDTO(Course course);

    public  List<ResponeCourseDTO> fromCourseListToResponeCourseDTOList(List<Course> CourseList);

    public int updateCourseStatus(int courseId, int status);

    public List<ResponeCourseDTO> findCoursesByInstructorId(int id);


    public int DeleteCourseByID(int courseId);


    public String getNameByID(int id);


}

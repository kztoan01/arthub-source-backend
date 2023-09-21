package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateCourseDTO;
import com.example.ArtHub.DTO.ResponeCourseDTO;
import com.example.ArtHub.Entity.Course;

import java.util.List;

public interface InterfaceOfCourseService {
    Course createCourse(CreateCourseDTO dto) throws AppServiceExeption;

    List<ResponeCourseDTO> getCourseList();
}

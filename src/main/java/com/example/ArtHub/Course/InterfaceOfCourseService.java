package com.example.ArtHub.Course;

import com.example.ArtHub.AppServiceExeption;

import java.util.List;

public interface InterfaceOfCourseService {
    Course createCourse(CreateCourseDTO dto) throws AppServiceExeption;

    List<Course> getCourseList();
}

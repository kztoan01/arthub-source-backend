package com.example.ArtHub.Service;


import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateCategoryCourseDTO;
import com.example.ArtHub.Entity.CategoryCourse;
import com.example.ArtHub.ResponeObject.ResponeObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InterfaceOfCategoryCourseService {
    CategoryCourse createCategoryCourse(CreateCategoryCourseDTO dto,int courseId) throws AppServiceExeption;

    List<CategoryCourse> getCategoris();

    List<CategoryCourse> getCategoriesByCourseID(int id);


    public int DeleteCategoryCourseByCourseID(int courseId);

}

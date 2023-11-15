package com.example.ArtHub.Service;


import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateCategoryCourseDTO;
import com.example.ArtHub.Entity.CategoryCourse;

import java.util.List;

public interface ICategoryCourseService {
    CategoryCourse createCategoryCourse(CategoryCourse dto,int courseId) throws AppServiceExeption;

    List<CategoryCourse> getCategoris();

    List<CategoryCourse> getCategoriesByCourseID(int id);


    public int DeleteCategoryCourseByCourseID(int courseId);

}

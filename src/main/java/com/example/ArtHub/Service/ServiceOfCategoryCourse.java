package com.example.ArtHub.Service;


import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateCategoryCourseDTO;
import com.example.ArtHub.Entity.CategoryCourse;
import com.example.ArtHub.Repository.CategoryCourseRepository;
import com.example.ArtHub.ResponeObject.ResponeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServiceOfCategoryCourse implements InterfaceOfCategoryCourseService {

    @Autowired
    CategoryCourseRepository categoryRepository;


    @Override
    public CategoryCourse createCategoryCourse(CreateCategoryCourseDTO dto, int courseId) throws AppServiceExeption {
        CategoryCourse category = new CategoryCourse();
        category.setCategoryId(dto.getCategoryId());
        category.setCourseId(courseId);
        return categoryRepository.save(category) ;
    }


    @Override
    public int DeleteCategoryCourseByCourseID(int courseId)
    {
        return categoryRepository.deleteCategoryCourseByCourseID(courseId);
    }



    @Override
    public List<CategoryCourse> getCategoris() {

        return categoryRepository.findAll();
    }

    @Override
    public List<CategoryCourse> getCategoriesByCourseID(int id) {
        return categoryRepository.findByCourseId(id);
    }
}

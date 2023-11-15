package com.example.ArtHub.Service;


import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateCategoryCourseDTO;
import com.example.ArtHub.Entity.CategoryCourse;
import com.example.ArtHub.Repository.CategoryCourseRepository;
import com.example.ArtHub.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOfCategoryCourse implements ICategoryCourseService {

    @Autowired
    CategoryCourseRepository categoryRepository;

    @Autowired
    CourseRepository courseRepository;


    @Override
    public CategoryCourse createCategoryCourse(CategoryCourse dto, int courseId) throws AppServiceExeption {
        CategoryCourse category = new CategoryCourse();
        category.setCategoryId(dto.getCategoryId());
        category.setCourse(courseRepository.findById(courseId).orElseThrow());
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

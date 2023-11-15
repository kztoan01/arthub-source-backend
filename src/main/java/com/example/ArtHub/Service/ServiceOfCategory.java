package com.example.ArtHub.Service;

import com.example.ArtHub.DTO.ResponeCategoryNameDTO;
import com.example.ArtHub.Entity.Category;
import com.example.ArtHub.Entity.CategoryCourse;
import com.example.ArtHub.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ServiceOfCategory implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ResponeCategoryNameDTO fromCategoryToCategotyResponeNameDTO(CategoryCourse categoryCourse) {
        ResponeCategoryNameDTO responeCategoryNameDTO = new ResponeCategoryNameDTO();
        Category category = categoryRepository.findAllById(Collections.singleton(categoryCourse.getCategoryId())).stream().findFirst().orElse(null);
        if (category != null) {
            responeCategoryNameDTO.setName(category.getName());
        }
        return responeCategoryNameDTO;
    }



}

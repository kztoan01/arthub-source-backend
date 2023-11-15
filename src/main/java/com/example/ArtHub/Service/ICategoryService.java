package com.example.ArtHub.Service;

import com.example.ArtHub.DTO.ResponeCategoryNameDTO;
import com.example.ArtHub.Entity.CategoryCourse;

public interface ICategoryService {



    public ResponeCategoryNameDTO fromCategoryToCategotyResponeNameDTO(CategoryCourse categoryCourse);
}

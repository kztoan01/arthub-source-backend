package com.example.ArtHub.DTO;

import com.example.ArtHub.Entity.Category;
import com.example.ArtHub.Entity.Section;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

public class ResponeCategoryDTO {

    ResponeCategoryDTO fromCategoryToCategotyResponeDTO(Category category)
    {
        ResponeCategoryDTO responeCategoryDTO = new ResponeCategoryDTO();

        responeCategoryDTO.setCategory_id(category.getId());
        responeCategoryDTO.setCategory_name(category.getName());

        return responeCategoryDTO;
    }


    List<ResponeCategoryDTO> fromCategoryListToCategoryDTOList(List<Category> CategoryList)
    {
        List<ResponeCategoryDTO> responeCategoryDTOS = new ArrayList<>();
        for (Category category : CategoryList) {
            responeCategoryDTOS.add(fromCategoryToCategotyResponeDTO(category));
        }
        return responeCategoryDTOS;
    }


    private int category_id;

    private String category_name;


    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}

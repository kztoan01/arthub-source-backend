package com.example.ArtHub.DTO;

import com.example.ArtHub.Entity.CategoryCourse;

import java.util.List;

public class ResponeCategoryNameDTO {

    ResponeCategoryNameDTO fromCategoryToCategotyResponeDTO(CategoryCourse category)
    {
//        ResponeCategoryDTO responeCategoryDTO = new ResponeCategoryDTO();
//
//        responeCategoryDTO.setId(category.getId());
//        responeCategoryDTO.setName(category.getCategoryId());

        return null;
    }


    List<ResponeCategoryNameDTO> fromCategoryListToCategoryDTOList(List<CategoryCourse> CategoryList)
    {
//        List<ResponeCategoryDTO> responeCategoryDTOS = new ArrayList<>();
//        for (Category category : CategoryList) {
//            responeCategoryDTOS.add(fromCategoryToCategotyResponeDTO(category));
//        }
        return null;
    }


    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

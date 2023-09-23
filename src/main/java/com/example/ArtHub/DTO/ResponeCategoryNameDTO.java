package com.example.ArtHub.DTO;

import com.example.ArtHub.Entity.CategoryCourse;
import com.example.ArtHub.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ResponeCategoryNameDTO {



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

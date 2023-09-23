package com.example.ArtHub.Entity;


import jakarta.persistence.*;

@Entity
public class CategoryCourse {

    @Id
    @Column(name = "categoryId")
    private int categoryId;

    @Column(name = "courseId")
    private int courseId;


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}

package com.example.ArtHub.Service;

import com.example.ArtHub.Entity.Course;

import java.util.List;

public interface ICourseSort {
    List<Course> findAllByOrderByPriceDesc();
    List<Course> findAllByOrderByPriceAsc();
    List<Course> findAllByOrderByDateDesc();
    List<Course> findAllByOrderByDateAsc();
}

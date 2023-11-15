package com.example.ArtHub.Service;

import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceOfCourseSort implements ICourseSort {
    private final CourseRepository repository;

    @Autowired
    public ServiceOfCourseSort(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Course> findAllByOrderByPriceDesc() {
        return repository.findAllByOrderByPriceDesc();
    }
    @Override
    public List<Course> findAllByOrderByPriceAsc() {
        return repository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Course> findAllByOrderByDateDesc() {
        return repository.findAllByOrderByDateDesc();
    }

    @Override
    public List<Course> findAllByOrderByDateAsc() {
        return repository.findAllByOrderByDateAsc();

    }
}

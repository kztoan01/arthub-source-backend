package com.example.ArtHub.Repository;


import com.example.ArtHub.Entity.CategoryCourse;
import com.example.ArtHub.Entity.CategoryCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryCourseRepository extends JpaRepository<CategoryCourse,Integer> {

    public List<CategoryCourse> findByCourseId(int id);

}

package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.CategoryCourse;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Entity.CourseRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRateRepository extends JpaRepository<CourseRate,Integer> {
    @Query("SELECT c FROM CourseRate c WHERE c.courseId = ?1")
    List<CourseRate> displayRateFromCourse(int courseId);
}

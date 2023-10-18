package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.CourseRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRateRepository extends JpaRepository<CourseRate,Integer> {
    @Query("SELECT cr FROM CourseRate  cr WHERE cr.courseId=?1")
    List<CourseRate> getCourseRateByCourseId(Integer courseId);

    Optional<CourseRate> getCourseRateByAccountIdAndCourseId(Integer accountId, Integer courseId);
}

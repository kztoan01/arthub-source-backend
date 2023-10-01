package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Entity.Enrollment;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    @Query("SELECT e from Enrollment e WHERE e.id= ?1")
    List<Enrollment> findById(int enrollmentId);



}

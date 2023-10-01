package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Learner, Integer> {
    @Query("SELECT l from Learner l WHERE l.id= ?1")
    List<Learner> findById(int enrollmentId);



}

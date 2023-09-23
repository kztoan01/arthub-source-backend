package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findByName(String name);

    @Query("SELECT c FROM Course c WHERE c.language LIKE %?1% AND c.price <= ?2 ")
    List<Course> findByLanguageAndPrice(String language, float price);


}




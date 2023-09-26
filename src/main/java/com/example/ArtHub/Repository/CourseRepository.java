package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    @Query("SELECT c FROM Course c WHERE c.name LIKE CONCAT('%', ?1, '%') OR c.introduction LIKE CONCAT('%', ?1, '%') OR c.description LIKE CONCAT('%', ?1, '%') ORDER BY \n" +
            "CASE \n" +
            "    WHEN c.name LIKE CONCAT(?1, '%') THEN 1 \n" +
            "    WHEN c.introduction LIKE CONCAT(?1, '%') THEN 2 \n" +
            "    WHEN c.description LIKE CONCAT(?1, '%') THEN 3 \n" +
            "    ELSE 4 \n" +
            "END ")
    List<Course> findCourseThatContainsKeyword(String keyword);


    @Query("SELECT c FROM Course c WHERE c.language LIKE %?1% AND c.price <= ?2 ")
    List<Course> findByLanguageAndPrice(String language, float price);


//<<<<<<< HEAD
    @Modifying
    @Transactional
    @Query("UPDATE Course c SET c.image = ?2 WHERE c.id = ?1 ")
    int  updateMainImage(int courseId, String imageName);
//=======

    @Query("SELECT c from Course c ORDER BY c.price DESC ")
    List<Course> findAllByOrderByPriceDesc();
    @Query("SELECT c from Course c ORDER BY c.price Asc ")
    List<Course> findAllByOrderByPriceAsc();

    @Query("SELECT c from Course c ORDER BY c.date DESC ")
    List<Course> findAllByOrderByDateDesc();

    @Query("SELECT c from Course c ORDER BY c.date ASC ")
    List<Course> findAllByOrderByDateAsc();



//>>>>>>> 48e575675ffe2c457a7aa96cf902668d1212d7e1

}




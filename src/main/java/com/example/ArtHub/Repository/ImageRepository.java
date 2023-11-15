package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {
    Image  findByCourseId(int CourseId);
    @Modifying
    @Transactional
    @Query("delete from Image i where i.course.id = ?1")
    int deleteImageByCourseId(int courseId);



    @Modifying
    @Transactional
    @Query("UPDATE Image i SET i.one = ?1, i.two = ?2, i.three = ?3, i.four = ?4 WHERE i.course.id = ?5")
    int updateImages(String one, String two, String three, String four, int courseId);

    boolean existsByCourseId(int courseId);
}

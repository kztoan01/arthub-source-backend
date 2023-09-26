package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {
    Image  findByCourseId(int CourseId);
}

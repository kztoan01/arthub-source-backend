package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video,Integer> {

    List<Video> findAllBySectionId(int sectionId);


    @Modifying
    @Transactional
    @Query("delete from Video v where v.id = ?1")
    int deleteViolatedCourse(int courseId);

}

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
    @Query("DELETE Video i WHERE i.id = ?1")
    int deleteVideo(int id);

    @Modifying
    @Transactional
    @Query("delete from Video v where v.sectionId = ?1")
    int deleteVideosBySectionID(int sectionID);

}

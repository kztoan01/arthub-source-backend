package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video,Integer> {

    List<Video> findAllBySectionId(int sectionId);

}
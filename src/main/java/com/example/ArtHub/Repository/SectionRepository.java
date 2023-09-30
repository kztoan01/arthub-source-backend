package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section,Integer> {

    List<Section> findByCourseId(int course);
}


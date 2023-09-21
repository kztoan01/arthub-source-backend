package com.example.ArtHub.Section;

import com.example.ArtHub.Course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section,Integer> {

    List<Section> findByCourse(int course);
}


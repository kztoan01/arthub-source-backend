package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section,Integer> {

    List<Section> findByCourseId(int course);

    @Modifying
    @Transactional
    @Query("delete from Section s  where s.course.id = ?1")
    int deleteSectionsByCourseID(int CourseID);
}


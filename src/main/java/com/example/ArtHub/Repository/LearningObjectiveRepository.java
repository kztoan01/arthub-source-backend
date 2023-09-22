package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.LearningObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningObjectiveRepository extends JpaRepository<LearningObjective,Integer> {

    LearningObjective findBycourseId(int course);

}

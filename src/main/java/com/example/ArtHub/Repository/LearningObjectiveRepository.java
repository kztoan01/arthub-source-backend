package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.LearningObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LearningObjectiveRepository extends JpaRepository<LearningObjective,Integer> {

    LearningObjective findBycourseId(int course);

    @Modifying
    @Transactional
    @Query(value = "delete from LearningObjective l where l.course.id = ?1")
    int deleteLearningObjectivesByCourseID(int courseID);

}

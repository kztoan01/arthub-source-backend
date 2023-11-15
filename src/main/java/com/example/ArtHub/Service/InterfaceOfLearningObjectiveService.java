package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateCourseDTO;
import com.example.ArtHub.DTO.CreateLearningObjectiveDTO;
import com.example.ArtHub.DTO.ResponeCourseDTO;
import com.example.ArtHub.DTO.ResponeLearningObjectiveDTO;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Entity.LearningObjective;

import java.util.List;

public interface InterfaceOfLearningObjectiveService {
    LearningObjective createLearningObjective(CreateLearningObjectiveDTO dto,int ID) throws AppServiceExeption;

    List<LearningObjective> getLearningObjectiveList();

    LearningObjective getLearningObjectiveByCourseId(int ID);
}

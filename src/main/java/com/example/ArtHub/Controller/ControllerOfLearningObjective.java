package com.example.ArtHub.Controller;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateLearningObjectiveDTO;
import com.example.ArtHub.DTO.ResponeLearningObjectiveDTO;
import com.example.ArtHub.Entity.LearningObjective;
import com.example.ArtHub.Service.ServiceOfLearningObjective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ControllerOfLearningObjective implements InterfaceOfLearningObjectiveController {

    @Autowired
    ServiceOfLearningObjective serviceOfLearningObjective;


    @Override
    public ResponeLearningObjectiveDTO createLearningObjective(CreateLearningObjectiveDTO dto) throws AppServiceExeption, IOException {
        LearningObjective learningObjective = serviceOfLearningObjective.createLearningObjective(dto,1);
        return ResponeLearningObjectiveDTO.fromLearningOjToResponeLearningOjDTO(learningObjective) ;
    }

    @Override
    public List<ResponeLearningObjectiveDTO> getLearningObjectives() {

        return null;
    }
}

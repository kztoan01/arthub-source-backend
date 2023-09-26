package com.example.ArtHub.Controller;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateLearningObjectiveDTO;
import com.example.ArtHub.DTO.ResponeLearningObjectiveDTO;
import com.example.ArtHub.InterfaceOfControllers.InterfaceOfLearningObjectiveController;
import com.example.ArtHub.Service.ServiceOfLearningObjective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControllerOfLearningObjective implements InterfaceOfLearningObjectiveController {

    @Autowired
    ServiceOfLearningObjective serviceOfLearningObjective;


    @Override
    public ResponeLearningObjectiveDTO createLearningObjective(CreateLearningObjectiveDTO dto) throws AppServiceExeption, IOException {

        return null;
    }

    @Override
    public List<ResponeLearningObjectiveDTO> getLearningObjectives() {

        return null;
    }
}

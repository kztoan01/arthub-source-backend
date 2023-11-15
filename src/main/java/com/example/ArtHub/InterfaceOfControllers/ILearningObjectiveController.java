package com.example.ArtHub.InterfaceOfControllers;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateLearningObjectiveDTO;
import com.example.ArtHub.DTO.ResponeLearningObjectiveDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/learningObjective")
public interface ILearningObjectiveController {

    @PostMapping("/addLearningObjective")
    @ResponseStatus(HttpStatus.CREATED)
    ResponeLearningObjectiveDTO createLearningObjective(@RequestBody @Valid CreateLearningObjectiveDTO dto) throws AppServiceExeption, IOException;


    @GetMapping("/getLearningObjective")
    List<ResponeLearningObjectiveDTO> getLearningObjectives();
}

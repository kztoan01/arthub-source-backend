package com.example.ArtHub.Controller;


import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateLearnerDTO;
import com.example.ArtHub.DTO.ResponseLearnerDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/learner")
public interface InterfaceOfLearnerController {
    @PostMapping("/addLearner")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseLearnerDTO createLearner(@RequestBody @Valid CreateLearnerDTO dto) throws AppServiceExeption, IOException;


}
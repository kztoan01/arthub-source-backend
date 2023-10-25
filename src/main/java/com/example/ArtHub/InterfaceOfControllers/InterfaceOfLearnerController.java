package com.example.ArtHub.InterfaceOfControllers;


import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateLearnerDTO;
import com.example.ArtHub.DTO.ResponseLearnerDTO;
import com.example.ArtHub.Entity.Learner;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/learner")
public interface InterfaceOfLearnerController {

    @PostMapping("/showStudentPurchase")
    ResponseEntity<List<Learner>> showStudentPurchase(@RequestParam Integer accountId);

    @PostMapping("/addLearner")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseLearnerDTO createLearner(@RequestBody @Valid CreateLearnerDTO dto) throws AppServiceExeption, IOException;

    @GetMapping("/getLearners")
    List<ResponseLearnerDTO> getLearnerList();

    @PostMapping("/countLearnerByOwner")
    @ResponseStatus(HttpStatus.CREATED)
    int countLearner(int owner) throws AppServiceExeption, IOException;


    @PostMapping("/GetProfitByOwner")
    @ResponseStatus(HttpStatus.CREATED)
    double getProfitByOwner(int owner) throws AppServiceExeption, IOException;


}
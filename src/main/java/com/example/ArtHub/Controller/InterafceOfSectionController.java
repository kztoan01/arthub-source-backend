package com.example.ArtHub.Controller;


import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateSectionDTO;
import com.example.ArtHub.DTO.ResponeSectionDTO;
import com.example.ArtHub.ResponeObject.ResponeObject;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/section")
public interface InterafceOfSectionController {

    @PostMapping("/addSection")
    @ResponseStatus(HttpStatus.CREATED)
    ResponeSectionDTO createSection(@RequestBody @Valid CreateSectionDTO dto) throws AppServiceExeption, IOException;


    @GetMapping("/getSections")
    List<ResponeSectionDTO> getSections();

    @GetMapping("/getSection/{id}")
    ResponseEntity<ResponeObject> getSectionByID(@PathVariable Integer id);


}

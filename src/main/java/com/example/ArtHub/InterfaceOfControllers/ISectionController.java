package com.example.ArtHub.InterfaceOfControllers;


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
public interface ISectionController {

    @PostMapping("/addSection")
    @ResponseStatus(HttpStatus.CREATED)
    ResponeSectionDTO createSection(@RequestBody @Valid CreateSectionDTO dto, int courseID , int accountID) throws AppServiceExeption, IOException;


    @GetMapping("/getSections")
    List<ResponeSectionDTO> getSections();

    @GetMapping("/getSection/{id}")
    ResponseEntity<ResponeObject> getSectionByCourseID(@PathVariable int id);


}

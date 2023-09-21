package com.example.ArtHub.Section;


import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.Course.CreateCourseDTO;
import com.example.ArtHub.Course.ResponeCourseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/section")
public interface InterafceOfSectionController {

    @PostMapping("/addSection")
    @ResponseStatus(HttpStatus.CREATED)
    ResponeSectionDTO createSection(@RequestBody @Valid CreateSectionDTO dto) throws AppServiceExeption, IOException;


    @GetMapping("/getSections")
    List<ResponeSectionDTO> getSections();


}

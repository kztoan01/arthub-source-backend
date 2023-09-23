package com.example.ArtHub.Controller;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateCourseDTO;
import com.example.ArtHub.DTO.ResponeCourseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/course")
public interface InterfaceOfCourseController {
    @PostMapping("/addCourse")
    @ResponseStatus(HttpStatus.CREATED)
    ResponeCourseDTO createCourse(@RequestBody @Valid CreateCourseDTO dto) throws AppServiceExeption, IOException;


    @GetMapping("/getCourses")
    List<ResponeCourseDTO> getCourses();


    @GetMapping("/getCourse/{name}")//search course by LIKE name
    List<ResponeCourseDTO> getCoursesByName(@PathVariable String name);

    @GetMapping("/getCourse/category/{category}")//search course by LIKE category
    List<ResponeCourseDTO> getCoursesByCategory(@PathVariable String category);





}

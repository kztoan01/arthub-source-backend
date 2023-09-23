package com.example.ArtHub.Controller;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateCourseDTO;
import com.example.ArtHub.DTO.ResponeCourseDTO;
import com.example.ArtHub.Entity.Course;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequestMapping("/course")
public interface InterfaceOfCourseController {

//    @GetMapping
//    public List<Course> getCourseWithLanguageAndPrice(@RequestParam String language, @RequestParam float price) {
//        return courseRepository.findByLanguageAndPrice(language, price);
//    }

    @PostMapping("/addCourse")
    @ResponseStatus(HttpStatus.CREATED)
    ResponeCourseDTO createCourse(@RequestBody @Valid CreateCourseDTO dto) throws AppServiceExeption, IOException;


    @GetMapping("/getCourses")
    List<ResponeCourseDTO> getCourses();


    @GetMapping("/getCourse/{name}")
    List<ResponeCourseDTO> getCourses(@PathVariable String name);


}

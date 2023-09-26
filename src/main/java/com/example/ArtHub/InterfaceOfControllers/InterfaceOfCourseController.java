package com.example.ArtHub.InterfaceOfControllers;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateCourseDTO;
import com.example.ArtHub.DTO.ResponeCourseDTO;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.ResponeObject.ResponeObject;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/course")
public interface InterfaceOfCourseController {

    // http://localhost:8080/course/thailan/5000
    @GetMapping("/{language}/{price}")
    List<ResponeCourseDTO> findAllCourseByLanguageAndPrice(@PathVariable String language, @PathVariable float price);

    @PostMapping("/addCourse")
    @ResponseStatus(HttpStatus.CREATED)
    ResponeCourseDTO createCourse(@RequestBody @Valid CreateCourseDTO dto) throws AppServiceExeption, IOException;


    @GetMapping("/getCourses")
    List<ResponeCourseDTO> getCourses();


    @GetMapping("/getCourse/{keyword}")//search course by keyword
    List<ResponeCourseDTO> findCourseThatContainsKeyword(@PathVariable String keyword);

    @GetMapping("/getCourse/category/{category}")//search course by LIKE category
    List<ResponeCourseDTO> getCoursesByCategory(@PathVariable String category);

    @PostMapping("/updateCourseStatus")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ResponeObject> updateStatusOfCourse(int courseId) throws AppServiceExeption, IOException;





    @PostMapping("/updateMainImage")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ResponeObject> updateMainImageOfCourse(int courseId, MultipartFile image) throws AppServiceExeption, IOException;







}

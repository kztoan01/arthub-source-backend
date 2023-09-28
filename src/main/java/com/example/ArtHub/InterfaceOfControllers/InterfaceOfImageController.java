package com.example.ArtHub.InterfaceOfControllers;


import com.example.ArtHub.DTO.CreateImageDTO;
import com.example.ArtHub.DTO.ResponeCourseDTO;
import com.example.ArtHub.Entity.Image;
import com.example.ArtHub.ResponeObject.ResponeObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/image")
public interface InterfaceOfImageController {

    @PostMapping("/saveCourseImages")
    ResponseEntity<ResponeObject> saveCourseImages(MultipartFile one, MultipartFile two, MultipartFile three, MultipartFile four, int courseId) throws IOException;

}

package com.example.ArtHub.InterfaceOfControllers;


import com.example.ArtHub.ResponeObject.ResponeObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/image")
public interface IImageController {

    @PostMapping("/saveCourseImages")
    ResponseEntity<ResponeObject> saveCourseImages(MultipartFile one, MultipartFile two, MultipartFile three, MultipartFile four, int courseId) throws IOException;

}

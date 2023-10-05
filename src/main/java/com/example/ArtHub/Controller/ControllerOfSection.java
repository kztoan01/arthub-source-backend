package com.example.ArtHub.Controller;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateSectionDTO;
import com.example.ArtHub.DTO.ResponeSectionDTO;
import com.example.ArtHub.InterfaceOfControllers.InterafceOfSectionController;
import com.example.ArtHub.ResponeObject.ResponeObject;
import com.example.ArtHub.Service.ServiceOfSection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControllerOfSection implements InterafceOfSectionController {

    @Autowired
    ServiceOfSection sectionService;


    @Override
    public ResponeSectionDTO createSection(CreateSectionDTO dto, int courseID, int accountID) throws AppServiceExeption, IOException {
        return null;
    }

    @Override
    public List<ResponeSectionDTO> getSections() {
        return null;
    }

    @Override
    public ResponseEntity<ResponeObject> getSectionByCourseID(int id) {
        return sectionService.getSectionByCourseID(id);

    }
}

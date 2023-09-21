package com.example.ArtHub.Controller;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.CreateSectionDTO;
import com.example.ArtHub.DTO.ResponeSectionDTO;
import com.example.ArtHub.Service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class SectionController implements InterafceOfSectionController {

    @Autowired
    SectionService sectionService;
    @Override
    public ResponeSectionDTO createSection(CreateSectionDTO dto) throws AppServiceExeption, IOException {
//        Section section = sectionService.createSection(dto);
//        return ResponeSectionDTO.FromSectionIntoResponeSectionDTO(section);
        return null;
    }

    @Override
    public List<ResponeSectionDTO> getSections() {
//        List<Section> SectionList =  sectionService.getSectionList();
//        return ResponeSectionDTO.fromSectionListToResponeSectionDTOList(SectionList);
        return null;
    }
}

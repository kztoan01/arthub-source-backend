package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.Entity.Section;
import com.example.ArtHub.Repository.SectionRepository;
import com.example.ArtHub.DTO.CreateSectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOfSection implements InterfaceOfSectionService {
    @Autowired
    SectionRepository sectionRepository ;


    @Override
    public Section createSection(CreateSectionDTO dto, int courseID) throws AppServiceExeption {
        Section section = new Section();
        section.setSection_name(dto.getSection_name());
        section.setAccount_id(dto.getAccount_id());
        section.setCourse(courseID);
        return sectionRepository.save(section);
    }

    @Override
    public List<Section> getSectionList(int ID) {
        List<Section> sectionList = sectionRepository.findByCourse(ID);
        return sectionList;
    }

    @Override
    public List<Section> getSectionListByCourseID(int ID) {
        return null;
    }
}

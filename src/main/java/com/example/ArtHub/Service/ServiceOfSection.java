package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.Entity.Section;
import com.example.ArtHub.Repository.SectionRepository;
import com.example.ArtHub.DTO.CreateSectionDTO;
import com.example.ArtHub.ResponeObject.ResponeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOfSection implements InterfaceOfSectionService {
    @Autowired
    SectionRepository sectionRepository ;


    @Override
    public Section createSection(CreateSectionDTO dto, int courseID) throws AppServiceExeption {
        Section section = new Section();
        section.setName(dto.getName());
        section.setAccountId(dto.getAccountId());
        section.setCourseId(courseID);
        return sectionRepository.save(section);
    }

    @Override
    public List<Section> getSectionList(int ID) {
//        List<Section> sectionList = sectionRepository.findBycourseId(ID);
//        return sectionList;
        return null;
    }

    @Override
    public List<Section> getSections() {
        List<Section> sectionList = sectionRepository.findAll();
        return sectionList;
    }

    @Override
    public ResponseEntity<ResponeObject> getSectionByCourseID(int id) {
        List<Section> foundSection = sectionRepository.findByCourseId(id);
        if(!foundSection.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("ok","Query product seccessfully", foundSection)
            );
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("false","Query product failed"+id,"")
            );
        }

    }
}

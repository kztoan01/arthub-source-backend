package com.example.ArtHub.Section;

import com.example.ArtHub.AppServiceExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService implements InterfaceOfSectionService {
    @Autowired
    SectionRepository sectionRepository ;


    @Override
    public Section createSection(CreateSectionDTO dto) throws AppServiceExeption {
        Section section = new Section();
        section.setSection_name(dto.getSection_name());
        section.setAccount_id(dto.getAccount_id());
        section.setCourse(dto.getCourse());
        return sectionRepository.save(section);
    }

    @Override
    public List<Section> getSectionList() {
        List<Section> sectionList = sectionRepository.findAll();
        return sectionList;
    }

    @Override
    public List<Section> getSectionListByCourseID(int ID) {
        return null;
    }
}

package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.ResponeSectionDTO;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Entity.Section;
import com.example.ArtHub.Repository.CourseRepository;
import com.example.ArtHub.Repository.SectionRepository;
import com.example.ArtHub.DTO.CreateSectionDTO;
import com.example.ArtHub.Repository.VideoRepository;
import com.example.ArtHub.ResponeObject.ResponeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOfSection implements ISectionService {
    @Autowired
    SectionRepository sectionRepository ;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    VideoRepository videoRepository;

    @Override
    public ResponeSectionDTO fromSectionIntoResponeSectionDTO(Section section,int id)
    {
        ResponeSectionDTO sectionDTO = new ResponeSectionDTO();
        sectionDTO.setSection_id(section.getId());
        sectionDTO.setSection_name(section.getName());
        sectionDTO.setCourse(id);
        sectionDTO.setAccount_id(section.getAccountId());
        sectionDTO.setVideos(videoRepository.findAllBySectionId(section.getId()));
        return sectionDTO;
    }


    @Override
    public Section createSection(Section dto, int id, Course course) throws AppServiceExeption {
        Section section = new Section();
        section.setName(dto.getName());
        section.setAccountId(id);
        section.setCourse(course);
        return sectionRepository.save(section);
    }

    @Override
    public int DeleteSectionByCourseID(int courseId)
    {
        return sectionRepository.deleteSectionsByCourseID(courseId);
    }

    @Override
    public List<Section> getSectionList(int ID) {
        List<Section> sectionList = sectionRepository.findByCourseId(ID);
        return sectionList;
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

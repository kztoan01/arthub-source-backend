package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.DTO.ResponeSectionDTO;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Entity.Section;
import com.example.ArtHub.DTO.CreateSectionDTO;
import com.example.ArtHub.ResponeObject.ResponeObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISectionService {


    Section createSection(Section dto, int id, Course course) throws AppServiceExeption;

    List<Section> getSectionList(int ID);

    public ResponeSectionDTO fromSectionIntoResponeSectionDTO(Section section,int id);

    public int DeleteSectionByCourseID(int courseId);

    List<Section> getSections();

    ResponseEntity<ResponeObject> getSectionByCourseID(int id);



}

package com.example.ArtHub.Service;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.Entity.Section;
import com.example.ArtHub.DTO.CreateSectionDTO;

import java.util.List;

public interface InterfaceOfSectionService {


    Section createSection(CreateSectionDTO dto, int courseID) throws AppServiceExeption;

    List<Section> getSectionList(int ID);

    List<Section> getSectionListByCourseID(int ID);



}

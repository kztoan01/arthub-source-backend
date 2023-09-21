package com.example.ArtHub.Section;

import com.example.ArtHub.AppServiceExeption;
import com.example.ArtHub.Course.Course;
import com.example.ArtHub.Course.CreateCourseDTO;

import java.util.List;

public interface InterfaceOfSectionService {


    Section createSection(CreateSectionDTO dto) throws AppServiceExeption;

    List<Section> getSectionList(int ID);

    List<Section> getSectionListByCourseID(int ID);



}

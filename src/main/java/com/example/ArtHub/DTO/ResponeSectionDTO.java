package com.example.ArtHub.DTO;

import com.example.ArtHub.Entity.Section;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ResponeSectionDTO {


    public static ResponeSectionDTO FromSectionIntoResponeSectionDTO(Section section)
    {
        ResponeSectionDTO sectionDTO = new ResponeSectionDTO();
        sectionDTO.setSection_id(section.getId());
        sectionDTO.setSection_name(section.getName());
        sectionDTO.setCourse(section.getCourseId());
        sectionDTO.setAccount_id(section.getAccountId());
        return sectionDTO;
    }

    public static List<ResponeSectionDTO> fromSectionListToResponeSectionDTOList(List<Section> SectionList) {
        List<ResponeSectionDTO> ResponeSectionDTOList = new ArrayList<>();
        for (Section section : SectionList) {
            ResponeSectionDTOList.add(FromSectionIntoResponeSectionDTO(section));
        }
        return ResponeSectionDTOList;
    }



    private Integer section_id;
    private String section_name;
    private Integer account_id;
    private Integer course;

    public Integer getSection_id() {
        return section_id;
    }

    public void setSection_id(Integer section_id) {
        this.section_id = section_id;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }
}
package com.example.ArtHub.Section;

import jakarta.validation.constraints.NotNull;

public class CreateSectionDTO {


    @NotNull(message = "Section name can not be null")
    private String section_name;
    private Integer account_id;
    private Integer course;




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

package com.example.ArtHub.Course;


import com.example.ArtHub.Section.CreateSectionDTO;
import com.example.ArtHub.Section.Section;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreateCourseDTO {


    @NotNull(message = "course_name cannot be null")
    @NotBlank(message = "course_name cannot be empty")
    private String  course_name;

    @NotNull(message = "course_description cannot be null")
    @NotBlank(message = "course_description cannot be empty")
    private String course_description;
    @NotNull(message = "course_introduction cannot be null")
    @NotBlank(message = "course_introduction cannot be empty")
    private String course_introduction;
    @NotNull(message = "course_level cannot be null")
    @NotBlank(message = "course_level cannot be empty")
    private String course_level;
    @NotNull(message = "course_language cannot be null")
    @NotBlank(message = "course_language cannot be empty")
    private String course_language;

    private Float course_price;


    private Float course_coupon;


    private boolean is_passed;
    @NotNull(message = "is_approved cannot be null")
    @NotBlank(message = "is_approved cannot be empty")
    private String is_approved;

    private Integer account_id;

    private Integer category_id;


    private List<CreateSectionDTO> sections;


    public List<CreateSectionDTO> getSections() {
        return sections;
    }

    public void setSections(List<CreateSectionDTO> sections) {
        this.sections = sections;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public String getCourse_introduction() {
        return course_introduction;
    }

    public void setCourse_introduction(String course_introduction) {
        this.course_introduction = course_introduction;
    }

    public String getCourse_level() {
        return course_level;
    }

    public void setCourse_level(String course_level) {
        this.course_level = course_level;
    }

    public String getCourse_language() {
        return course_language;
    }

    public void setCourse_language(String course_language) {
        this.course_language = course_language;
    }

    public Float getCourse_price() {
        return course_price;
    }

    public void setCourse_price(Float course_price) {
        this.course_price = course_price;
    }

    public Float getCourse_coupon() {
        return course_coupon;
    }

    public void setCourse_coupon(Float course_coupon) {
        this.course_coupon = course_coupon;
    }

    public boolean isIs_passed() {
        return is_passed;
    }

    public void setIs_passed(boolean is_passed) {
        this.is_passed = is_passed;
    }

    public String getIs_approved() {
        return is_approved;
    }

    public void setIs_approved(String is_approved) {
        this.is_approved = is_approved;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}

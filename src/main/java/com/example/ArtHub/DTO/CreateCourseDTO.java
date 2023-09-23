package com.example.ArtHub.DTO;


import com.example.ArtHub.Entity.CategoryCourse;

import java.util.Date;
import java.util.List;

public class CreateCourseDTO {


    private Integer id;

    private String  name;


    private String description;


    private String introduction;


    private String level;



    private String language;



    private Float price;



    private Float coupon;



    private boolean isPassed;



    private boolean isApproved;


    private Integer accountId;

    private String image;

    private Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    private List<CreateCategoryCourseDTO> categories;

    private List<CreateSectionDTO> sections;
    private CreateLearningObjectiveDTO learningObjective;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getCoupon() {
        return coupon;
    }

    public void setCoupon(Float coupon) {
        this.coupon = coupon;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public List<CreateCategoryCourseDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CreateCategoryCourseDTO> categories) {
        this.categories = categories;
    }

    public CreateLearningObjectiveDTO getLearningObjective() {
        return learningObjective;
    }

    public void setLearningObjective(CreateLearningObjectiveDTO learningObjective) {
        this.learningObjective = learningObjective;
    }

    public List<CreateSectionDTO> getSections() {
        return sections;
    }

    public void setSections(List<CreateSectionDTO> sections) {
        this.sections = sections;
    }


}

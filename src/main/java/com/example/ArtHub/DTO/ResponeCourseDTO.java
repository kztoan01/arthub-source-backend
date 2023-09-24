package com.example.ArtHub.DTO;

import com.example.ArtHub.Entity.CategoryCourse;
import com.example.ArtHub.Entity.LearningObjective;
import com.example.ArtHub.Entity.Section;
import com.example.ArtHub.Service.ServiceOfSection;

import java.util.Date;
import java.util.List;

public class ResponeCourseDTO {
    ServiceOfSection sectionService = new ServiceOfSection();


    private Integer id;

    private String  name;

    private String image;


    private String description;


    private String introduction;


    private String level;



    private String language;



    private Float price;



    private Float coupon;



    private boolean isPassed;



    private Boolean isApproved;


    private Integer accountId;


    private Integer categoryId;

    private List<Section> sections;
    private LearningObjective learningObjective;

    private List<ResponeCategoryNameDTO> categories;

    private Date date;

    private String instructorName;

    private String intructorImage;

    private String instructorPhone;

    private String intructorAddress;

    private String instrutorEmail;

    private String instructorTwitter;

    private String instructorFacebook;

    public String getIntructorImage() {
        return intructorImage;
    }

    private String bio;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setIntructorImage(String intructorImage) {
        this.intructorImage = intructorImage;
    }

    public String getInstructorPhone() {
        return instructorPhone;
    }

    public void setInstructorPhone(String instructorPhone) {
        this.instructorPhone = instructorPhone;
    }

    public String getIntructorAddress() {
        return intructorAddress;
    }

    public void setIntructorAddress(String intructorAddress) {
        this.intructorAddress = intructorAddress;
    }

    public String getInstrutorEmail() {
        return instrutorEmail;
    }

    public void setInstrutorEmail(String instrutorEmail) {
        this.instrutorEmail = instrutorEmail;
    }

    public String getInstructorTwitter() {
        return instructorTwitter;
    }

    public void setInstructorTwitter(String instructorTwitter) {
        this.instructorTwitter = instructorTwitter;
    }

    public String getInstructorFacebook() {
        return instructorFacebook;
    }

    public void setInstructorFacebook(String instructorFacebook) {
        this.instructorFacebook = instructorFacebook;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ResponeCategoryNameDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<ResponeCategoryNameDTO> categories) {
        this.categories = categories;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public LearningObjective getLearningObjective() {
        return learningObjective;
    }

    public void setLearningObjective(LearningObjective learningObjective) {
        this.learningObjective = learningObjective;
    }
}

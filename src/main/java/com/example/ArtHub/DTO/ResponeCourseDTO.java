package com.example.ArtHub.DTO;

import com.example.ArtHub.Entity.*;
import com.example.ArtHub.Service.ServiceOfSection;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

public class ResponeCourseDTO {

    private Integer id;

    private String  name;

    private String description;


    private String introduction;

    private String level;



    private String language;


    private Float price;



    private Float coupon;



    private Boolean isPassed;

    private Integer Status;


    private String image;


    private Date date;

















    private Integer accountId;


    private Integer categoryId;

    private List<ResponeSectionDTO> sections;


    private ResponeLearningObjectiveDTO learningObjective;

    private List<ResponeCategoryNameDTO> categories;

    private List<ResponeStudentInfor> Students;

    private String instructorName;

    private String instructorImage;

    private String instructorPhone;

    private String instructorAddress;

    private String instructorEmail;

    private String instructorTwitter;

    private String instructorFacebook;

    private ResponeImageDTO images;

    private int count;
    private Float avg;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Float getAvg() {
        return avg;
    }

    public void setAvg(Float avg) {
        this.avg = avg;
    }


    public ResponeImageDTO getImages() {
        return images;
    }

    public void setImages(ResponeImageDTO images) {
        this.images = images;
    }

    public String getInstructorImage() {
        return instructorImage;
    }

    public void setInstructorImage(String instructorImage) {
        this.instructorImage = instructorImage;
    }

    public String getInstructorAddress() {
        return instructorAddress;
    }

    public void setInstructorAddress(String instructorAddress) {
        this.instructorAddress = instructorAddress;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }

    private String bio;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    public String getInstructorPhone() {
        return instructorPhone;
    }

    public void setInstructorPhone(String instructorPhone) {
        this.instructorPhone = instructorPhone;
    }


    public List<ResponeStudentInfor> getStudents() {
        return Students;
    }

    public void setStudents(List<ResponeStudentInfor> students) {
        Students = students;
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

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
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

    public Boolean getPassed() {
        return isPassed;
    }

    public void setPassed(Boolean passed) {
        isPassed = passed;
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

    public List<ResponeSectionDTO> getSections() {
        return sections;
    }

    public void setSections(List<ResponeSectionDTO> sections) {
        this.sections = sections;
    }


    public ResponeLearningObjectiveDTO getLearningObjective() {
        return learningObjective;
    }

    public void setLearningObjective(ResponeLearningObjectiveDTO learningObjective) {
        this.learningObjective = learningObjective;
    }
}

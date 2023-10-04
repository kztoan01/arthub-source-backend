
        package com.example.ArtHub.DTO;

public class CreateLearnerDTO {
    private Integer accountId;
    private Integer courseId;
    private Integer ownerCourse;
    private Float price;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getOwnerCourse() {
        return ownerCourse;
    }

    public void setOwnerCourse(Integer ownerCourse) {
        this.ownerCourse = ownerCourse;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
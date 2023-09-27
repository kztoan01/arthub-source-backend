
        package com.example.ArtHub.DTO;

public class CreateLearnerDTO {
    private Integer accountId;
    private Integer courseId;
    private Integer ownerCourse;
    private Double price;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
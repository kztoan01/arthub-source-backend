package com.example.ArtHub.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Entity
@Table (name = "Learner")
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "accountId")
    private Integer accountId;
    @Column(name = "courseId")
    private Integer courseId;
    @Column(name = "ownerCourse")
    private Integer ownerCourse;
    @Column(name = "date")
    @CreationTimestamp
    private Date date;
    @Column(name = "price")
    private Double price;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
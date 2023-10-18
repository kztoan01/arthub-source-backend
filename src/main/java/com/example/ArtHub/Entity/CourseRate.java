package com.example.ArtHub.Entity;

import jakarta.persistence.*;

import org.hibernate.annotations.CreationTimestamp;


import java.util.Date;

@Entity
@Table(name = "CourseRate")
public class CourseRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true,name = "id")
    private int id;

    @Column(name = "timeRate")
    private Date timeRate;

    @Column(name = "rate")
    private int rate;


    @Column(name = "comment")
    private String comment;
    @Column(name = "accountId")
    private Integer accountId;
    @Column(name = "courseId")
    private Integer courseId;


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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimeRate() {
        return timeRate;
    }

    public void setTimeRate(Date timeRate) {
        this.timeRate = timeRate;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }


}

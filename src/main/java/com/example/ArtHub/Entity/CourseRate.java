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
    @CreationTimestamp
    private Date timeRate;
    @Column(name = "rate")
    private int rate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "courseId")
    private int courseId;
    @Column(name = "accountId")
    private int accountId;

    public CourseRate() {
    }

    public CourseRate(int rate, String comment, int courseId, int accountId) {
        this.rate = rate;
        this.comment = comment;
        this.courseId = courseId;
        this.accountId = accountId;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}

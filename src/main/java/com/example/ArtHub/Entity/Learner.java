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
    @Column(name = "accountId", insertable = false, updatable = false)
    private Integer accountId;
    @Column(name = "courseId", insertable = false, updatable = false)
    private Integer courseId;
    @Column(name = "ownerCourse")
    private Integer ownerCourse;
    @Column(name = "date")
    @CreationTimestamp
    private Date date;
    @Column(name = "price")
    private Float price;
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "accountId")
    private Account account;
    @Column(name = "status")
    private Integer status;
    @Column(name = "senderId")
    private Integer senderId;
    @Column(name = "message")
    private String message;

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Account getAccount() {
        return account;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}

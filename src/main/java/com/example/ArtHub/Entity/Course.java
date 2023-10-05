package com.example.ArtHub.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String  name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "introduction")
    private String introduction;

    @Column(name = "level")
    private String level;


    @Column(name = "language")
    private String language;


    @Column(name = "price")
    private Float price;


    @Column(name = "coupon")
    private Float coupon;


    @Column(name = "isPassed")
    private Boolean isPassed;



    @Column(name = "accountId")
    private Integer accountId;


    @Column(name = "Status")
    private Integer Status = 0;



    @Column(name = "image")
    private String image;

    @Column(name = "date")
    @CreationTimestamp
    private Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}

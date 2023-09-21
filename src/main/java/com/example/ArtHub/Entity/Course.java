package com.example.ArtHub.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    private Integer course_id;
    @Column(nullable = false,name="course_name")
    private String  course_name;
    @Column(nullable = false,name = "course_description")
    private String course_description;
    @Column(nullable = false,name = "course_introduction")
    private String course_introduction;
    @Column(nullable = false,name = "course_level")
    private String course_level;

    @Column(nullable = false,name = "course_language")
    private String course_language;

    @Column(nullable = false,name = "course_price")
    private Float course_price;

    @Column(nullable = false,name = "course_coupon")
    private Float course_coupon;

    @Column(nullable = false,name = "is_passed")
    private boolean is_passed;

    @Column(nullable = false,name = "is_approved")
    private String is_approved;
    @Column(nullable = false,name = "account_id")
    private Integer account_id;
    @Column(nullable = false,name = "category_id")
    private Integer category_id;


    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public String getCourse_introduction() {
        return course_introduction;
    }

    public void setCourse_introduction(String course_introduction) {
        this.course_introduction = course_introduction;
    }

    public String getCourse_level() {
        return course_level;
    }

    public void setCourse_level(String course_level) {
        this.course_level = course_level;
    }

    public String getCourse_language() {
        return course_language;
    }

    public void setCourse_language(String course_language) {
        this.course_language = course_language;
    }

    public Float getCourse_price() {
        return course_price;
    }

    public void setCourse_price(Float course_price) {
        this.course_price = course_price;
    }

    public Float getCourse_coupon() {
        return course_coupon;
    }

    public void setCourse_coupon(Float course_coupon) {
        this.course_coupon = course_coupon;
    }

    public boolean isIs_passed() {
        return is_passed;
    }

    public void setIs_passed(boolean is_passed) {
        this.is_passed = is_passed;
    }

    public String getIs_approved() {
        return is_approved;
    }

    public void setIs_approved(String is_approved) {
        this.is_approved = is_approved;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}

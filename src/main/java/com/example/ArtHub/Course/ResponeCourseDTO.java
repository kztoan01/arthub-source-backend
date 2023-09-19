package com.example.ArtHub.Course;

import com.example.ArtHub.Account.Account;
import com.example.ArtHub.Account.AccountResponeDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ResponeCourseDTO {

    public static ResponeCourseDTO fromCourseToResponeCourseDTO(Course course) {
        ResponeCourseDTO courseDTO = new ResponeCourseDTO();
        courseDTO.setCourse_name(course.getCourse_name());
        courseDTO.setCourse_description(course.getCourse_description());
        courseDTO.setCourse_price(course.getCourse_price());
        courseDTO.setCourse_coupon(course.getCourse_coupon());
        courseDTO.setCourse_id(course.getCourse_id());
        courseDTO.setCourse_language(course.getCourse_language());
        courseDTO.setCourse_level(course.getCourse_level());
        courseDTO.setAccount_id(course.getAccount_id());
        courseDTO.setCategory_id(course.getCategory_id());
        courseDTO.setIs_approved(course.getIs_approved());
        courseDTO.setIs_passed(course.isIs_passed());
        courseDTO.setCourse_introduction(course.getCourse_introduction());
        return courseDTO;
    }

    public static List<ResponeCourseDTO> fromCourseListToResponeCourseDTOList(List<Course> CourseList) {
        List<ResponeCourseDTO> ResponeCourseDTOList = new ArrayList<>();
        for (Course course : CourseList) {
            ResponeCourseDTOList.add(fromCourseToResponeCourseDTO(course));
        }
        return ResponeCourseDTOList;
    }


   private String course_id;

    private String  course_name;


    private String course_description;

    private String course_introduction;

    private String course_level;

    private String course_language;


    private Float course_price;


    private Float course_coupon;


    private boolean is_passed;

    private String is_approved;

    private Integer account_id;

    private Integer category_id;


    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
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

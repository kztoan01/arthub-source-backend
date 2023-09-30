package com.example.ArtHub.DTO;

import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Entity.LearningObjective;

import java.util.ArrayList;
import java.util.List;

public class ResponeLearningObjectiveDTO {


    private int id;
    private String one;

    private String two;

    private String three;

    private String four;



    private Integer course;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }


    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }
}

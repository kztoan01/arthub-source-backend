package com.example.ArtHub.DTO;

import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Entity.LearningObjective;

import java.util.ArrayList;
import java.util.List;

public class ResponeLearningObjectiveDTO {

    public static ResponeLearningObjectiveDTO fromLearningOjToResponeLearningOjDTO(LearningObjective learningObjective) {
        ResponeLearningObjectiveDTO responeLearningObjectiveDTO = new ResponeLearningObjectiveDTO();
        responeLearningObjectiveDTO.setId(learningObjective.getLearningObjective_id());
        responeLearningObjectiveDTO.setCourse(learningObjective.getCourse());
        responeLearningObjectiveDTO.setOne(learningObjective.getOne());
        responeLearningObjectiveDTO.setTwo(learningObjective.getTwo());
        responeLearningObjectiveDTO.setThree(learningObjective.getThree());
        responeLearningObjectiveDTO.setFour(learningObjective.getFour());
        responeLearningObjectiveDTO.setFive(learningObjective.getFive());
        responeLearningObjectiveDTO.setSix(learningObjective.getSix());
        return responeLearningObjectiveDTO;
    }

    public static List<ResponeLearningObjectiveDTO> fromLearningOjListIntoLearningOjDTOList(List<LearningObjective> learningOjList) {
        List<ResponeLearningObjectiveDTO> learningOjResponseDTOList = new ArrayList<>();
        for (LearningObjective learningObjective : learningOjList) {
            learningOjResponseDTOList.add(fromLearningOjToResponeLearningOjDTO(learningObjective));
        }
        return learningOjResponseDTOList;
    }

    private int id;
    private String one;

    private String two;

    private String three;

    private String four;

    private String five;

    private String six;

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

    public String getFive() {
        return five;
    }

    public void setFive(String five) {
        this.five = five;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }
}

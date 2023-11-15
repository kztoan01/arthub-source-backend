package com.example.ArtHub.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LearningObjectives")
public class LearningObjective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "one")
    private String one;
    @Column(name = "two")
    private String two;
    @Column(name = "three")
    private String three;
    @Column(name = "four")
    private String four;
    @Column(name = "courseId")
    private Integer courseId;




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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}

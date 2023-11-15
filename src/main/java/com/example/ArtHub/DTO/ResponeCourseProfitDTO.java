package com.example.ArtHub.DTO;

public class ResponeCourseProfitDTO {

    private int id;

    private int SumProfit;


    private int courseId;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    private int lastMonthProfit;

    private String name;

    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSumProfit() {
        return SumProfit;
    }

    public void setSumProfit(int sumProfit) {
        SumProfit = sumProfit;
    }

    public int getLastMonthProfit() {
        return lastMonthProfit;
    }

    public void setLastMonthProfit(int lastMonthProfit) {
        this.lastMonthProfit = lastMonthProfit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

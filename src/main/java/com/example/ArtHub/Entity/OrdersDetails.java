package com.example.ArtHub.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "OrdersDetails")
@IdClass(OrderDetailId.class)
public class OrdersDetails {
    @Id
    private  int orderId;
    @Id
    private int courseId;

    @ManyToOne
    @JoinColumn(name = "orderId",insertable=false, updatable=false)
    private Orders orders;


    @ManyToOne
    @JoinColumn(name = "courseId",insertable=false, updatable=false)
    private Course course;


    @Column(name = "finalPrice")
    private Float finalPrice;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}

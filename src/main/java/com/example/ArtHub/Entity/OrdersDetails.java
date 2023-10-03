package com.example.ArtHub.Entity;

import jakarta.persistence.*;

@Entity
public class OrdersDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    private float finalPrice;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders orders;

    public OrdersDetails() {
    }

    public OrdersDetails(int id, Course course, float finalPrice, Orders orders) {
        this.id = id;
        this.course = course;
        this.finalPrice = finalPrice;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}


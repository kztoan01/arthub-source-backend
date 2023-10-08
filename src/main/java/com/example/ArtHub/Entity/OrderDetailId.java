package com.example.ArtHub.Entity;

import jakarta.persistence.Embeddable;


import java.io.Serializable;
import java.util.Objects;


public class OrderDetailId implements Serializable {

    private int orderId;
    private int courseId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailId that = (OrderDetailId) o;
        return orderId == that.orderId && courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, courseId);
    }
}

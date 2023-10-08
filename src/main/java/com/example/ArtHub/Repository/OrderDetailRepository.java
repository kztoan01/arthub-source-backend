package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Course;

import com.example.ArtHub.Entity.OrderDetailId;
import com.example.ArtHub.Entity.Orders;
import com.example.ArtHub.Entity.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrdersDetails, Integer> {
    Optional<OrdersDetails> findByOrdersAndCourse(Orders orders, Optional<Course> course);
    List<OrdersDetails> findByCourseId(Integer courseId);
    List<OrdersDetails> findByOrders(Orders order);

}

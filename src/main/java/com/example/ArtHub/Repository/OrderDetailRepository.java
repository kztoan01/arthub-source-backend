package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrdersDetails,Integer> {
}

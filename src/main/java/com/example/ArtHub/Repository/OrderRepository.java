package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    Orders findByAccount(Account account);
}

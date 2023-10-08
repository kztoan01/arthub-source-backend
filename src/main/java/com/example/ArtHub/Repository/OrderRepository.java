package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Account;
import com.example.ArtHub.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    List<Orders>  findByAccountId(Integer accountId);

    List<Orders> findByAccount(Account account);
}

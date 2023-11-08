package com.example.ArtHub.Repository;

import com.example.ArtHub.DTO.PayoutDTO;
import com.example.ArtHub.Entity.Course;
import com.example.ArtHub.Entity.Payout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PayoutRepository extends JpaRepository<Payout, Integer> {
    Optional<Payout> findByAccountId(int id);

    @Query("SELECT p from Payout p where p.accountId = ?1")
    Payout findPayoutByAccountId(int id);
    @Query("SELECT ownerCourse, SUM(price) as TotalPayout FROM Learner GROUP BY ownerCourse")
    List<Payout> displayAllAccountAndPrice();




//    @Query("SELECT  Payout.accountId, SUM(Learner.price) as TotalPayout, Payout.platform, Payout.recipientName, Payout.recipientUsername, Payout.recipientEmail, Payout.recipientPhone\n" +
//            "FROM Payout\n" +
//            "INNER JOIN Learner ON Payout.accountId=Learner.ownerCourse group by Payout.accountId, Payout.platform, Payout.recipientName, Payout.recipientUsername, Payout.recipientEmail, Payout.recipientPhone")
//    List<PayoutDTO> displayAllPayout();
}

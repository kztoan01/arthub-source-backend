package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LearnerRepository extends JpaRepository<Learner, Integer> {

    @Query("SELECT COUNT(DISTINCT l.accountId) FROM Learner l WHERE l.ownerCourse = :owner GROUP BY l.ownerCourse")
    Integer countDistinctAccountIdByOwner(@Param("owner") int owner);

    @Query("SELECT SUM(l.price) FROM Learner l WHERE l.ownerCourse = :owner")
    Double sumOfProfit(@Param("owner") int owner);
}

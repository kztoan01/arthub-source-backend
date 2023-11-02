package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
    public boolean existsByUsername(String username);
    List<Account> findByRoleId(String roleId);
    List<Account> findByUsernameContaining (String username);
    Optional<Account> findById(int accountID);
    Optional<Account> findByEmail(String email);
    Optional<Account> findByUsername(String username);
    @Modifying
    @Transactional
    @Query("UPDATE Account c SET c.image = ?2 WHERE c.id = ?1 ")
    int  updateMainImageAccount(int courseId, String imageName);

}

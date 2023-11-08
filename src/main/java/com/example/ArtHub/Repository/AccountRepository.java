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
    int updateMainImageAccount(int courseId, String imageName);

    @Modifying
    @Transactional
    @Query("UPDATE Account c SET c.password = ?2 WHERE c.email = ?1 ")
    int updatePassword(String email, String password);
    @Modifying
    @Transactional
    @Query("UPDATE Account c SET c.token = null WHERE c.id = ?1 ")
    int updateToken(int id);

    @Modifying
    @Transactional
    @Query("UPDATE Account c SET c.isPremium = ?2 WHERE c.id = ?1 ")
    int updatePremium( int id , String ipre);
}

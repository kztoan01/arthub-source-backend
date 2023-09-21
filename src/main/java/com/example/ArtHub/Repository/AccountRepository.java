package com.example.ArtHub.Repository;

import com.example.ArtHub.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
    public boolean existsByUsername(String username);

}

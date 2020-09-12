package com.aneirine.userservice.api.users;

import com.aneirine.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    User findByEmail(String email);

    @Query("select s from User  s where ?1  member of s.vaultIdList ")
    User findByVaults(long id);

    @Query("select s from User  s where ?1  member of s.transactionIdList ")
    User findByTransactions(long id);
}

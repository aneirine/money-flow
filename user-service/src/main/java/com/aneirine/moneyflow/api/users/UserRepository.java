package com.aneirine.moneyflow.api.users;

import com.aneirine.moneyflow.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

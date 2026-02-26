package com.shrunkhal.userapp.playerdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shrunkhal.userapp.playerdata.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
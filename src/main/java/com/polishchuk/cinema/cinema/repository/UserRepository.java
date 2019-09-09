package com.polishchuk.cinema.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.polishchuk.cinema.cinema.data.entity.User;

import java.math.BigInteger;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, BigInteger> {
  User findByUsername(String username);
}

package com.titos.balancetogether.repository;

import com.titos.balancetogether.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
}
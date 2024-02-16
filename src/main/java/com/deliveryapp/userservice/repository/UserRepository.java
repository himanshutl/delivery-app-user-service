package com.deliveryapp.userservice.repository;

import com.deliveryapp.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

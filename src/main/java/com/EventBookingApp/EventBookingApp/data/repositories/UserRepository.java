package com.EventBookingApp.EventBookingApp.data.repositories;

import com.EventBookingApp.EventBookingApp.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

    User findByUserId(Long Id);
}

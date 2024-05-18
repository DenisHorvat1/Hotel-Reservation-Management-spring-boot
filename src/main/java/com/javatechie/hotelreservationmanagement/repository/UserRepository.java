package com.javatechie.hotelreservationmanagement.repository;

import com.javatechie.hotelreservationmanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

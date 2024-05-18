package com.javatechie.hotelreservationmanagement.repository;

import com.javatechie.hotelreservationmanagement.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}

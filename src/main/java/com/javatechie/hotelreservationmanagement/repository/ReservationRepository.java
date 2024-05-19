package com.javatechie.hotelreservationmanagement.repository;

import com.javatechie.hotelreservationmanagement.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByHotelId(Long hotelId);
    List<Reservation> findByRoomIdAndCheckOutAfterAndCheckInBefore(Long roomId, LocalDateTime checkIn, LocalDateTime checkOut);
}

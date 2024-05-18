package com.javatechie.hotelreservationmanagement.service;

import com.javatechie.hotelreservationmanagement.entity.Reservation;
import com.javatechie.hotelreservationmanagement.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    public boolean canModifyReservation(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        return reservation.map(res -> res.getCheckIn().isAfter(LocalDateTime.now().plusHours(2))).orElse(false);
    }
}

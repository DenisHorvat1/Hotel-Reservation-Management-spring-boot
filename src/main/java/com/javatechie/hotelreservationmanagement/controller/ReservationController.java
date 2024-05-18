package com.javatechie.hotelreservationmanagement.controller;

import com.javatechie.hotelreservationmanagement.entity.Reservation;
import com.javatechie.hotelreservationmanagement.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @DeleteMapping("/{id}")
    public void deleteReservationById(@PathVariable Long id) {
        reservationService.deleteReservationById(id);
    }

    @PutMapping("/{id}/cancel")
    public void cancelReservation(@PathVariable Long id) {
        if (reservationService.canModifyReservation(id)) {
            reservationService.deleteReservationById(id);
        } else {
            throw new IllegalStateException("Cannot cancel reservation less than 2 hours before check-in");
        }
    }
}

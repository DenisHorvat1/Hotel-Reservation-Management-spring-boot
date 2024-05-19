package com.javatechie.hotelreservationmanagement.service;

import com.javatechie.hotelreservationmanagement.entity.Reservation;
import com.javatechie.hotelreservationmanagement.entity.Room;
import com.javatechie.hotelreservationmanagement.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomService roomService;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, RoomService roomService) {
        this.reservationRepository = reservationRepository;
        this.roomService = roomService;
    }

    public Reservation saveReservation(Reservation reservation) {
        Room room = roomService.getRoomById(reservation.getRoomId()).orElse(null);
        if(reservation.getCheckOut() == null){ //if a reservation is closed
            room.setIsAvailable(true);
            roomService.saveRoom(room);
            return reservationRepository.save(reservation);
        }
        if(room == null) {
            return null;
        }
        if(!room.getIsAvailable() ){
            return null;
        }
        room.setIsAvailable(false);
        roomService.saveRoom(room);
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

    public List<Reservation> getReservationsByHotelId(Long hotelId) {
        return reservationRepository.findByHotelId(hotelId);
    }
}

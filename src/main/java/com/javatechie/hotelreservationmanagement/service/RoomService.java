package com.javatechie.hotelreservationmanagement.service;

import com.javatechie.hotelreservationmanagement.entity.Reservation;
import com.javatechie.hotelreservationmanagement.entity.Room;
import com.javatechie.hotelreservationmanagement.repository.ReservationRepository;
import com.javatechie.hotelreservationmanagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public void deleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }

    public long countRooms() {
        return roomRepository.count();
    }

    public boolean isRoomAvailable(Long roomId, LocalDateTime checkIn, LocalDateTime checkOut) {
        List<Reservation> reservations = reservationRepository.findByRoomIdAndCheckOutAfterAndCheckInBefore(
                roomId, checkIn, checkOut);
        return reservations.isEmpty();
    }


}

package com.javatechie.hotelreservationmanagement.repository;

import com.javatechie.hotelreservationmanagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByPriceLessThan(double price);
}

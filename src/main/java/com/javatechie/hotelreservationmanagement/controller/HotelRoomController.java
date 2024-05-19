package com.javatechie.hotelreservationmanagement.controller;

import com.javatechie.hotelreservationmanagement.entity.Hotel;
import com.javatechie.hotelreservationmanagement.service.HotelService;
import com.javatechie.hotelreservationmanagement.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels/room")
public class HotelRoomController {
    private final HotelService hotelService;
    private final RoomService roomService;

    public HotelRoomController(HotelService hotelService, RoomService roomService) {
        this.hotelService = hotelService;
        this.roomService = roomService;
    }

    @PostMapping
    public Hotel saveHotelWithRoom(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    @GetMapping
    public List<Hotel> findAllHotels(){
        return hotelService.getAllHotels();
    }

    @GetMapping("/{hotelId}")
    public Hotel findHotelById(@PathVariable Long hotelId) {
        return hotelService.getHotelById(hotelId).orElse(null);
    }

    @GetMapping("find/{name}")
    public List<Hotel> findHotelContainingByName(@PathVariable String name) {
        return hotelService.getHotelByName(name);
    }

    @DeleteMapping("all")
    public void deleteAllHotels(){
        hotelService.deleteAllHotels();
    }
    @DeleteMapping("/{hotelId}")
    public void deleteHotelById(@PathVariable Long hotelId) {
        hotelService.deleteHotelById(hotelId);
    }

    @GetMapping("/nearby")
    public List<Hotel> getHotelsNearby(@RequestParam double latitude, @RequestParam double longitude, @RequestParam double radiusKm) {
        return hotelService.findHotelsNearby(latitude, longitude, radiusKm);
    }

}

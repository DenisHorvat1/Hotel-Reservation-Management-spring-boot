package com.javatechie.hotelreservationmanagement.service;

import com.javatechie.hotelreservationmanagement.entity.Hotel;
import com.javatechie.hotelreservationmanagement.entity.Room;
import com.javatechie.hotelreservationmanagement.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public void deleteHotelById(Long id) {
        hotelRepository.deleteById(id);
    }

    public long countHotels() {
        return hotelRepository.count();
    }

    public List<Hotel> getHotelByName(String name) {
        return  hotelRepository.findByNameContaining(name);
    }

    public void deleteAllHotels() {
        hotelRepository.deleteAll();
    }

    public List<Hotel> findHotelsNearby(double latitude, double longitude, double radiusKm) {
        List<Hotel> allHotels = hotelRepository.findAll();
        return allHotels.stream()
                .filter(hotel -> calculateDistance(latitude, longitude, hotel.getLatitude(), hotel.getLongitude()) <= radiusKm)
                .collect(Collectors.toList());
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the Earth in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // distance in km
    }


}

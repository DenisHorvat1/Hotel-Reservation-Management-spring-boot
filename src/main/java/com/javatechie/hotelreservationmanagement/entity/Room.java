package com.javatechie.hotelreservationmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "COURSE_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    private int roomNumber;
    private int type;
    private double price;
    private Boolean isAvailable;

    @ManyToMany(mappedBy = "rooms", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Hotel> hotels;
}

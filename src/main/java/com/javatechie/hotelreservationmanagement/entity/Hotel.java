package com.javatechie.hotelreservationmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "HOTEL_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double latitude;
    private double longitude;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "HOTEL_ROOM_TABLE",
            joinColumns = {
                    @JoinColumn(name="hotel_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "room_id", referencedColumnName = "id")
            }
    )
    private Set<Room> rooms;
}

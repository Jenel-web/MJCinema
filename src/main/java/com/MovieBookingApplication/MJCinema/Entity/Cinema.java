package com.MovieBookingApplication.MJCinema.Entity;

import jakarta.persistence.*;

@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="cinema_id")
    private Integer cinemaId;
    @Column(nullable = false)
    private String location;

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

package com.MovieBookingApplication.MJCinema.Repository;

import com.MovieBookingApplication.MJCinema.Entity.Cinema;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer>{

}

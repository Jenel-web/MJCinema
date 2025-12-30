package com.MovieBookingApplication.MJCinema.Repository;

import com.MovieBookingApplication.MJCinema.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    boolean existsByTmdbId(Long tmdbId);
}

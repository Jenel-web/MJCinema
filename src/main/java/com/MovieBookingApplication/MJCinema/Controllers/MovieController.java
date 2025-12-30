package com.MovieBookingApplication.MJCinema.Controllers;

import com.MovieBookingApplication.MJCinema.DTO.AddMovieRequest;
import com.MovieBookingApplication.MJCinema.Entity.Movie;
import com.MovieBookingApplication.MJCinema.Services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addMovie (@RequestBody AddMovieRequest request){
        if (request.getId() == null) {
            throw new IllegalArgumentException("TMDB ID cannot be null");
        }
        if(movieService.addMovie(request.getId())){
            return ResponseEntity.ok("Movie saved successfully.");
        }
        else{
            return ResponseEntity.badRequest().body("Movie not saved.");
            //in case it's a bad request.
        }
    }
}

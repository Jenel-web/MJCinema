package com.MovieBookingApplication.MJCinema.Services;

import com.MovieBookingApplication.MJCinema.DTO.TmdbMovieDTO;
import com.MovieBookingApplication.MJCinema.DTO.TmdbMovieResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class TmdbService { //will handle the fetching of data from TMDB

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public TmdbService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    // Search for movies by title
    public List<TmdbMovieDTO> searchMovies(String query) {
        String url = String.format("%s/search/movie?api_key=%s&query=%s", baseUrl, apiKey, query);

        TmdbMovieResponse response =
                restTemplate.getForObject(url, TmdbMovieResponse.class);
        //capture the response first then return it.
        return (response != null)? response.getResults() : List.of();
    }//searches for movies by forming a url.

    public TmdbMovieDTO getMovieDetails(Long tmdbId){
        String url = String.format( "%s/movie/%d?api_key=%s", baseUrl, tmdbId, apiKey);
        //transform to string format.
                return restTemplate.getForObject(url, TmdbMovieDTO.class);
        // you can return the object itself without the ternary operator.
    }

    public List<TmdbMovieDTO> getPopularMovies() {
        String url = baseUrl + "/movie/popular?api_key=" + apiKey;
        TmdbMovieResponse response =
                restTemplate.getForObject(url, TmdbMovieResponse.class);

        return (response != null)? response.getResults() : List.of();
        //returns the result if there is and an empty list if none.
    }
}

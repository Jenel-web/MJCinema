package com.MovieBookingApplication.MJCinema.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)//ignores properties that are not found in DTO
public class TmdbMovieResponse {

    private List<TmdbMovieDTO> results;
    private TmdbMovieDTO movieDTO;
    public List<TmdbMovieDTO> getResults() {
        return results;
    } //this is the one that outputs when we call the tmdb controller.

    public void setResults(List<TmdbMovieDTO> results) {
        this.results = results;
    }
}

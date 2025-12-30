package com.MovieBookingApplication.MJCinema.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShowingSchedResponse {
    private String title;
    private LocalDate showDate;
    private String cinema;
    private LocalTime startTime;

    public ShowingSchedResponse(String title, LocalDate showDate, String cinema, LocalTime startTime) {
        this.title = title;
        this.showDate = showDate;
        this.cinema = cinema;
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
}

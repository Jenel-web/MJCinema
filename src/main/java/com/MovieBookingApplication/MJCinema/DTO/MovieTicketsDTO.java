package com.MovieBookingApplication.MJCinema.DTO;

import com.MovieBookingApplication.MJCinema.Entity.SeatCategory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MovieTicketsDTO {
    private String username;
    private String title;
    private String cinema;
    private String seatNumber;
    private SeatCategory seatCategory;
    private String ticketCode;
    private LocalDate showDate;
    private LocalTime startTime;

    public MovieTicketsDTO(String username,
                           String title,
                           String cinema,
                           String seatNumber,
                           SeatCategory seatCategory,
                           String ticketCode,
                           LocalDate showDate,
                           LocalTime startTime) {
        this.username = username;
        this.title = title;
        this.cinema = cinema;
        this.seatNumber = seatNumber;
        this.seatCategory = seatCategory;
        this.ticketCode = ticketCode;
        this.showDate = showDate;
        this.startTime = startTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCinema() {
        return cinema;
    }

    public void setCinema(String cinema) {
        this.cinema = cinema;
    }

    public String getSeat() {
        return seatNumber;
    }

    public void setSeat(String seat) {
        this.seatNumber = seatNumber;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
}

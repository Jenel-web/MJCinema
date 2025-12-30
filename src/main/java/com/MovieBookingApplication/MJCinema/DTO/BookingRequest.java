package com.MovieBookingApplication.MJCinema.DTO;

public class BookingRequest {
    private Integer scheduleId;
    private String seat;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}

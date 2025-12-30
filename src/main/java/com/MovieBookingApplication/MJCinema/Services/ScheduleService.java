package com.MovieBookingApplication.MJCinema.Services;

import com.MovieBookingApplication.MJCinema.DTO.ShowAvailableSeatsResponse;
import com.MovieBookingApplication.MJCinema.DTO.ShowingSchedResponse;
import com.MovieBookingApplication.MJCinema.Entity.Seat;
import com.MovieBookingApplication.MJCinema.Entity.SeatPrice;
import com.MovieBookingApplication.MJCinema.Repository.ScheduleRepository;
import com.MovieBookingApplication.MJCinema.Repository.SeatPriceRepository;
import com.MovieBookingApplication.MJCinema.Repository.SeatRespository;
import com.MovieBookingApplication.MJCinema.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private SeatRespository seatRespository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private SeatPriceRepository seatPriceRepository;

    public List<ShowingSchedResponse> nowShowing(){
         return scheduleRepository.FindNowShowingSchedules();
    }

    public Map<String, List<ShowAvailableSeatsResponse>> showAvailableSeats(Integer scheduleId){

        //make list of all seats
        List<Seat> cinemaSeats = seatRespository.findByScheduleId(scheduleId);

        //make list of taken seats
        List<String> takeSeats = ticketRepository.FindSeatSeatNumberByScheduleId(scheduleId);

        //make a map that groups them by row
        Map<String, List< ShowAvailableSeatsResponse>> map = new TreeMap<>();

        for(Seat seat : cinemaSeats){
            String row = seat.getSeatNumber().substring(0,1);//takes the first character which is a letter.

            ShowAvailableSeatsResponse dto = new ShowAvailableSeatsResponse();
            dto.setSeatNumber(seat.getSeatNumber());
            dto.setSeatCategory(seat.getSeatCategory());
            SeatPrice seatPrice = seatPriceRepository.findBySeatCategoryAndScheduleScheduleId(seat.getSeatCategory(), scheduleId).orElseThrow(
                    ()->new RuntimeException("seat price not found.")
            );
            dto.setPrice((seatPrice.getPrice()));
            dto.setAvailable(!takeSeats.contains(seat.getSeatNumber()));

            map.computeIfAbsent(row, k -> new ArrayList<>()).add(dto);
            //essential when dealing with maps.
        }

        return map;
    }
}

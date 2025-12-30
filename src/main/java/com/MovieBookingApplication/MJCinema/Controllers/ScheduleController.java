package com.MovieBookingApplication.MJCinema.Controllers;

import com.MovieBookingApplication.MJCinema.DTO.ShowAvailableRequest;
import com.MovieBookingApplication.MJCinema.DTO.ShowAvailableSeatsResponse;
import com.MovieBookingApplication.MJCinema.DTO.ShowingSchedResponse;
import com.MovieBookingApplication.MJCinema.Services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/now-showing")
    public List<ShowingSchedResponse> nowShowing(){
        return scheduleService.nowShowing();
    }
    @GetMapping("/seats")
    public ResponseEntity <Map<String, List<ShowAvailableSeatsResponse>>> showAvailableSeats(@RequestBody ShowAvailableRequest request){
        Map<String, List<ShowAvailableSeatsResponse>> map = scheduleService.showAvailableSeats(request.getScheduleId());
         return ResponseEntity.ok(map);
    }
}

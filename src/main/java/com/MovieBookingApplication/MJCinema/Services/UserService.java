package com.MovieBookingApplication.MJCinema.Services;

import com.MovieBookingApplication.MJCinema.DTO.MovieTicketsDTO;
import com.MovieBookingApplication.MJCinema.Entity.Users;
import com.MovieBookingApplication.MJCinema.Repository.TicketRepository;
import com.MovieBookingApplication.MJCinema.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private TicketRepository ticketRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public Users registerUser(String username, String password){
        Users u = new Users();
        u.setUsername(username);
        u.setPassword(passwordEncoder.encode(password));
        u.setRole("USER");
        return userRepository.save(u);
    }

    public List<MovieTicketsDTO> showTickets(String username){
        return ticketRepository.FindTicketsByUserUsername(username);
    }

}

package com.example._300344953umarsalih.web;

import com.example._300344953umarsalih.entities.Seat;
import com.example._300344953umarsalih.repos.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class SeatController {

    @Autowired
    private SeatRepository seatRepository;

    @GetMapping(path = "/index")
    public String seats(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {

        List<Seat> seats = seatRepository.findAll();
        model.addAttribute("listSeats", seats);

        return "seats";
    }
}

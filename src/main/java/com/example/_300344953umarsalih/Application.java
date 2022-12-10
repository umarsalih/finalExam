package com.example._300344953umarsalih;

import com.example._300344953umarsalih.entities.Seat;
import com.example._300344953umarsalih.repos.SeatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(SeatRepository seatRepository){
		return args -> {
			seatRepository.save(new Seat(null, "Jona Elan", new Date(), "10"));
			seatRepository.findAll().forEach(p->{
				System.out.println(p.getName());
			});
		};
	}

}

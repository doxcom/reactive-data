package com.example.reactive_data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactiveDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveDataApplication.class, args);
	}

}


interface ReservationRepository extends ReactiveMongoRepository<Reservation, String> {

	Flux<Reservation> findByReservationName(String rn);
}

@Data
@AllArgsConstructor
@Document
class Reservation{

	@Id
	private String id;

	private String reservationName;

}

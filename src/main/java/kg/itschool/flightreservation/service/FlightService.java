package kg.itschool.flightreservation.service;

import kg.itschool.flightreservation.model.dto.FlightDto;
import kg.itschool.flightreservation.model.request.CreateFligthRequest;
import kg.itschool.flightreservation.model.response.CustomerFlightResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface FlightService {
    FlightDto create(CreateFligthRequest request);
    List<CustomerFlightResponse> findAll(LocalDate currentDate);
}

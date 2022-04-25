package kg.itschool.flightreservation.service;

import kg.itschool.flightreservation.model.dto.FlightDto;
import kg.itschool.flightreservation.model.entity.Flight;
import kg.itschool.flightreservation.model.request.CreateFligthRequest;
import org.springframework.stereotype.Service;

@Service
public interface FlightService {
    FlightDto create(CreateFligthRequest request);
}

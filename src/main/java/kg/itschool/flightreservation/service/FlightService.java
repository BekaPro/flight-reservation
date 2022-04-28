package kg.itschool.flightreservation.service;

import kg.itschool.flightreservation.model.dto.FlightDto;
import kg.itschool.flightreservation.model.request.CreateBookingRequest;
import kg.itschool.flightreservation.model.request.CreateFligthRequest;
import kg.itschool.flightreservation.model.response.CustomerFlightResponse;
import kg.itschool.flightreservation.model.response.MessageResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface FlightService {
    FlightDto create(CreateFligthRequest request);
    List<CustomerFlightResponse> findAll(LocalDate currentDate, String cityFrom, String cityTo);
    MessageResponse book(CreateBookingRequest request);
    List<CustomerFlightResponse> getFlightsByCustomers(Long id);

    MessageResponse cancelBooking(CreateBookingRequest request);
}

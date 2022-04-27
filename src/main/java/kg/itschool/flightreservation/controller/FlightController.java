package kg.itschool.flightreservation.controller;

import kg.itschool.flightreservation.model.request.CreateBookingRequest;
import kg.itschool.flightreservation.model.request.CreateFligthRequest;
import kg.itschool.flightreservation.model.response.CustomerFlightResponse;
import kg.itschool.flightreservation.model.response.MessageResponse;
import kg.itschool.flightreservation.service.FlightService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/flight")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightController {

    @NonNull FlightService flightService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateFligthRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(flightService.create(request));
    }

    @GetMapping("/find-all")
    public ResponseEntity<?> findAll(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate currentDate,
                                     @RequestParam("from") String cityFrom,
                                     @RequestParam("to") String cityTo) {

        List<CustomerFlightResponse> result = flightService.findAll(currentDate, cityFrom, cityTo);

        if (result.isEmpty()) {
            return ResponseEntity.ok(MessageResponse.sendMessage("No available flights found"));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    @PostMapping("/book")
    public ResponseEntity<?> bookFlight(@RequestBody CreateBookingRequest request) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(flightService.book(request));
    }

}

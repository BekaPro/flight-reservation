package kg.itschool.flightreservation.controller;

import kg.itschool.flightreservation.model.request.CreateFligthRequest;
import kg.itschool.flightreservation.service.FlightService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

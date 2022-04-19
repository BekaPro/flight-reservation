package kg.itschool.flightreservation.controller;

import kg.itschool.flightreservation.model.entity.Customer;
import kg.itschool.flightreservation.model.entity.Wallet;
import kg.itschool.flightreservation.model.request.CreateCustomerRequest;
import kg.itschool.flightreservation.repository.CustomerRepository;
import kg.itschool.flightreservation.repository.WalletRepository;
import kg.itschool.flightreservation.service.CustomerService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerController {

    @NonNull CustomerService customerService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody @Validated CreateCustomerRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerService.create(request));
    }
}
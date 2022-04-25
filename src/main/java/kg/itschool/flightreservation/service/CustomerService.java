package kg.itschool.flightreservation.service;

import kg.itschool.flightreservation.model.dto.CustomerDto;
import kg.itschool.flightreservation.model.request.CreateCustomerRequest;

public interface CustomerService {
    CustomerDto create(CreateCustomerRequest request);
    CustomerDto getById(Long id);
}

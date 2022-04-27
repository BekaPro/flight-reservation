package kg.itschool.flightreservation.service;

import kg.itschool.flightreservation.model.dto.CustomerDto;
import kg.itschool.flightreservation.model.request.CreateCustomerRequest;
import kg.itschool.flightreservation.model.response.CustomerResponse;

public interface CustomerService {
    CustomerDto create(CreateCustomerRequest request);
    CustomerResponse getById(Long id);
}

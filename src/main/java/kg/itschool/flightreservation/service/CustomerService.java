package kg.itschool.flightreservation.service;

import kg.itschool.flightreservation.model.entity.Customer;
import kg.itschool.flightreservation.model.request.CreateCustomerRequest;

public interface CustomerService {
    Customer create(CreateCustomerRequest request);
}

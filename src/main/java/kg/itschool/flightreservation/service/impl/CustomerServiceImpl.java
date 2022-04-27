package kg.itschool.flightreservation.service.impl;

import kg.itschool.flightreservation.exceptions.EntityNotFoundException;
import kg.itschool.flightreservation.model.dto.CustomerDto;
import kg.itschool.flightreservation.model.entity.Customer;
import kg.itschool.flightreservation.model.entity.Wallet;
import kg.itschool.flightreservation.model.mapper.CustomerMapper;
import kg.itschool.flightreservation.model.request.CreateCustomerRequest;
import kg.itschool.flightreservation.model.response.CustomerResponse;
import kg.itschool.flightreservation.repository.CustomerRepository;
import kg.itschool.flightreservation.service.CustomerService;
import kg.itschool.flightreservation.service.FlightService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerServiceImpl implements CustomerService {

    @NonNull CustomerRepository customerRepository;

    @Lazy
    @Autowired FlightService flightService;

    @Override
    public CustomerDto create(CreateCustomerRequest request) {
        return CustomerMapper.INSTANCE
                .toDto(customerRepository
                        .save(Customer
                                .builder()
                                .wallet(Wallet
                                        .builder()
                                        .funds(request.getFunds())
                                        .build())
                                .phoneNumber(request.getPhoneNumber())
                                .patronymic(request.getPatronymic())
                                .lastName(request.getLastName())
                                .email(request.getEmail())
                                .firstName(request.getFirstName())
                                .build()));
    }

    @Override
    public CustomerResponse getById(Long id) {
        Customer customer = getEntityById(id);
        return CustomerResponse
                .builder()
                .flightResponseList(flightService.getFlightsByCustomers(id))
                .email(customer.getEmail())
                .firstName(customer.getFirstName())
                .id(customer.getId())
                .fullName(customer.getFullName())
                .funds(customer.getWallet().getFunds())
                .lastName(customer.getLastName())
                .patronymic(customer.getPatronymic())
                .phoneNumber(customer.getPhoneNumber())
                .build();
    }

    List<Customer> getCustomersByIds(List<Long> ids) {
        return customerRepository.findAllById(ids);
    }

    Customer getEntityById(Long id) {
        return customerRepository.
                findById(id).orElseThrow(() ->
                        new EntityNotFoundException("Customer with id=\" + id + \" not found\""));
    }
    // DRY - Don't repeat yourself
}
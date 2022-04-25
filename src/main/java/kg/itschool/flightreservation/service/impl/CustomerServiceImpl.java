package kg.itschool.flightreservation.service.impl;

import kg.itschool.flightreservation.exceptions.EntityNotFoundException;
import kg.itschool.flightreservation.model.dto.CustomerDto;
import kg.itschool.flightreservation.model.entity.Customer;
import kg.itschool.flightreservation.model.entity.Wallet;
import kg.itschool.flightreservation.model.mapper.CustomerMapper;
import kg.itschool.flightreservation.model.request.CreateCustomerRequest;
import kg.itschool.flightreservation.repository.CustomerRepository;
import kg.itschool.flightreservation.service.CustomerService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerServiceImpl implements CustomerService {

    @NonNull CustomerRepository customerRepository;

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
    public CustomerDto getById(Long id) {
        return CustomerMapper.INSTANCE.toDto(customerRepository.
                findById(id).orElseThrow(() ->
                        new EntityNotFoundException("Customer with id=\" + id + \" not found\"")));
//        return customerRepository
//                .findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Customer with id=" + id + " not found"));
    }
}
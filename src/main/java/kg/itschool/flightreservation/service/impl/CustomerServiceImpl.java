package kg.itschool.flightreservation.service.impl;

import kg.itschool.flightreservation.model.entity.Customer;
import kg.itschool.flightreservation.model.entity.Wallet;
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
    public Customer create(CreateCustomerRequest request) {
        Wallet wallet = new Wallet();
        wallet.setFunds(request.getFunds());

        Customer customer = new Customer();
        customer.setWallet(wallet);
        customer.setName(request.getName());

        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Customer with id=" + id + " not found"));
    }
}
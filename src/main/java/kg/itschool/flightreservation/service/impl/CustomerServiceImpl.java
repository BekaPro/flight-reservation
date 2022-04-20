package kg.itschool.flightreservation.service.impl;

import kg.itschool.flightreservation.exceptions.EntityNotFoundException;
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

        String fullName = ( // "John Doe S"
                        request.getLastName().trim() + " " +
                        request.getFirstName().trim() + " " +
                        request.getPatronymic()).trim();

        Customer customer = new Customer();
        customer.setEmail(request.getEmail().trim());
        customer.setWallet(wallet);
        customer.setFirstName(request.getFirstName().trim());
        customer.setLastName(request.getLastName().trim());
        customer.setPatronymic(request.getPatronymic().trim());
        customer.setPhoneNumber(request.getPhoneNumber().trim());
        customer.setFullName(fullName);

        return customerRepository.save(customer);
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer with id=" + id + " not found"));
    }
}
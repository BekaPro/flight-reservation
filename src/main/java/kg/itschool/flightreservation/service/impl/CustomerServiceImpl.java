package kg.itschool.flightreservation.service.impl;

import kg.itschool.flightreservation.exceptions.EntityNotFoundException;
import kg.itschool.flightreservation.model.dto.CustomerDto;
import kg.itschool.flightreservation.model.dto.WalletDto;
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
    public CustomerDto create(CreateCustomerRequest request) {
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

        customerRepository.save(customer);

        return CustomerDto
                .builder()
                .id(customer.getId())
                .dateUpdated(customer.getDateUpdated())
                .dateCreated(customer.getDateCreated())
                .email(customer.getEmail())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .patronymic(customer.getPatronymic())
                .phoneNumber(customer.getPhoneNumber())
                .fullName(customer.getFullName())
                .wallet(WalletDto
                        .builder()
                        .id(wallet.getId())
                        .funds(wallet.getFunds())
                        .dateCreated(wallet.getDateCreated())
                        .dateUpdated(wallet.getDateUpdated())
                        .build())
                .build();
    }

    @Override
    public CustomerDto getById(Long id) {
        return null;
//        return customerRepository
//                .findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("Customer with id=" + id + " not found"));
    }
}
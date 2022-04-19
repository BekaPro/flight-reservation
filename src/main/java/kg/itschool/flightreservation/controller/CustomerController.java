package kg.itschool.flightreservation.controller;

import kg.itschool.flightreservation.model.entity.Customer;
import kg.itschool.flightreservation.model.entity.Wallet;
import kg.itschool.flightreservation.repository.CustomerRepository;
import kg.itschool.flightreservation.repository.WalletRepository;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerController {

    @NonNull CustomerRepository customerRepository;
    @NonNull WalletRepository walletRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Customer create(@RequestParam String name,
                           @RequestParam BigDecimal funds) {
        Wallet wallet = new Wallet();
        wallet.setFunds(funds);

        walletRepository.save(wallet);

        Customer customer = new Customer();
        customer.setName(name);
        customer.setWallet(wallet);

        return customerRepository.save(customer);
    }
}
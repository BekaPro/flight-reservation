package kg.itschool.flightreservation.repository;

import kg.itschool.flightreservation.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
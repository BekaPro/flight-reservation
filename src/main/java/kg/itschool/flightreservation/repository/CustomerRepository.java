package kg.itschool.flightreservation.repository;

import kg.itschool.flightreservation.model.entity.Customer;
import kg.itschool.flightreservation.model.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
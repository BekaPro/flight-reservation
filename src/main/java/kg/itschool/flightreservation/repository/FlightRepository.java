package kg.itschool.flightreservation.repository;

import kg.itschool.flightreservation.model.entity.Flight;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllById (Long id);
    List<Flight> findAllByFlightDate(LocalDate flightDate);
}
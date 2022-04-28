package kg.itschool.flightreservation.repository;

import kg.itschool.flightreservation.model.entity.Customer;
import kg.itschool.flightreservation.model.entity.Flight;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllById (Long id);
    List<Flight> findAllByFlightDateAndFromCityNameAndToCityName(LocalDate flightDate, String cityFrom, String cityTo);

//    @Query("SELECT f FROM Flight f join fetch f.passengers WHERE f.passengers = :cust") // Hibernate query language
    @Query(value = "" +
            "SELECT * FROM tb_flights f " +
            "JOIN tb_booking b on f.id = b.flight_id " +
            "JOIN tb_customer c on c.id = b.customer_id " +
            "WHERE c.id = ?1", nativeQuery = true)
    List<Flight> findAllByPassenger(Customer customer);

    @Modifying
    @Query(value = "DELETE FROM tb_booking WHERE customer_id = ?1 AND flight_id = ?2", nativeQuery = true)
    void deleteFromBooking(Long customerId, Long flightId);

}
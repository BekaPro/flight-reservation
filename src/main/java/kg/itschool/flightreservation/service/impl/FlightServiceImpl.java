package kg.itschool.flightreservation.service.impl;

import kg.itschool.flightreservation.model.dto.FlightDto;
import kg.itschool.flightreservation.model.entity.City;
import kg.itschool.flightreservation.model.entity.Flight;
import kg.itschool.flightreservation.model.entity.Plane;
import kg.itschool.flightreservation.model.mapper.FlightMapper;
import kg.itschool.flightreservation.model.request.CreateFligthRequest;
import kg.itschool.flightreservation.repository.FlightRepository;
import kg.itschool.flightreservation.service.CityService;
import kg.itschool.flightreservation.service.FlightService;
import kg.itschool.flightreservation.service.PlaneService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlightServiceImpl implements FlightService {

    @NonNull FlightRepository flightRepository;
    @NonNull PlaneService planeService;
    @NonNull CityService cityService;

    @Override
    public FlightDto create(CreateFligthRequest request) {
        Plane plane = ((PlaneServiceImpl) planeService).getById(request.getPlaneId());
        City to = ((CityServiceImpl) cityService).getCityByStateAndName(request.getStateTo(), request.getCityTo());
        City from = ((CityServiceImpl) cityService).getCityByStateAndName(request.getStateFrom(), request.getCityFrom());

        BigDecimal speed = BigDecimal.valueOf(700);
        BigDecimal distance = calculateDistance(from.getLat(), to.getLat(), from.getLon(), to.getLon());

        BigDecimal result = distance.divide(speed, RoundingMode.CEILING);

        System.out.println(result);

        Flight flight = Flight
                .builder()
                .to(to)
                .from(from)
                .flightDate(request.getFlightDate())
                .departureTime(request.getDepartureTime())
                .plane(plane)
                .price(request.getPrice())
                .build();

        return FlightMapper.INSTANCE
                .toDto(flightRepository.save(flight));
    }

    private BigDecimal calculateDistance(BigDecimal latFrom, BigDecimal latTo, BigDecimal lonFrom, BigDecimal lonTo) {
        BigDecimal res = BigDecimal.valueOf(0.5).subtract(BigDecimal.valueOf(Math.cos((latTo.doubleValue() - latFrom.doubleValue()) * Math.PI)).divide(BigDecimal.valueOf(2))).add(
                BigDecimal.valueOf(Math.cos(latFrom.doubleValue() * Math.PI) * Math.cos(latTo.doubleValue() * Math.PI)).multiply(
                        (BigDecimal.ONE.subtract(BigDecimal.valueOf(Math.cos((lonTo.doubleValue() - lonFrom.doubleValue()) * Math.PI)))).divide(BigDecimal.valueOf(2))));

        return BigDecimal.valueOf(12742).multiply(BigDecimal.valueOf(Math.asin(Math.sqrt(res.doubleValue()))));
    }

}

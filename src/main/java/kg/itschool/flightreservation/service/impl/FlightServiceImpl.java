package kg.itschool.flightreservation.service.impl;

import kg.itschool.flightreservation.model.dto.FlightDto;
import kg.itschool.flightreservation.model.entity.City;
import kg.itschool.flightreservation.model.entity.Flight;
import kg.itschool.flightreservation.model.entity.Plane;
import kg.itschool.flightreservation.model.mapper.FlightMapper;
import kg.itschool.flightreservation.model.request.CreateFligthRequest;
import kg.itschool.flightreservation.model.response.CityResponse;
import kg.itschool.flightreservation.model.response.CustomerFlightResponse;
import kg.itschool.flightreservation.model.response.PlaneResponse;
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
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

        Flight flight = Flight
                .builder()
                .to(to)
                .from(from)
                .flightDate(request.getFlightDate())
                .departureTime(request.getDepartureTime())
                .arrivalTime(request.getArrivalTime())
                .plane(plane)
                .price(request.getPrice())
                .build();

        return FlightMapper.INSTANCE
                .toDto(flightRepository.save(flight));
    }

    @Override
    public List<CustomerFlightResponse> findAll(LocalDate currentDate) {
        return flightRepository
                .findAllByFlightDate(currentDate)
                .stream()
                .map(flight -> CustomerFlightResponse
                        .builder()
                        .flightTime(flight.getArrivalTime())
                        .id(flight.getId())
                        .flightDate(flight.getFlightDate())
                        .from(CityResponse
                                .builder()
                                .state(flight.getFrom().getState())
                                .cityName(flight.getFrom().getCityName())
                                .build())
                        .to(CityResponse
                                .builder()
                                .state(flight.getTo().getState())
                                .cityName(flight.getTo().getCityName())
                                .build())
                        .departureTime(flight.getDepartureTime())
                        .plane(PlaneResponse
                                .builder()
                                .supplierName(flight.getPlane().getSupplier().getSupplierName())
                                .model(flight.getPlane().getModel())
                                .build())
                        .price(flight.getPrice())
                        .build())
                .collect(Collectors.toList());
    }
}

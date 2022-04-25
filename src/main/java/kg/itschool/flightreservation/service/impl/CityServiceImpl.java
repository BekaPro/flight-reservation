package kg.itschool.flightreservation.service.impl;

import kg.itschool.flightreservation.exceptions.EntityNotFoundException;
import kg.itschool.flightreservation.model.dto.CityDto;
import kg.itschool.flightreservation.model.entity.City;
import kg.itschool.flightreservation.model.mapper.CityMapper;
import kg.itschool.flightreservation.model.request.CreateCityRequest;
import kg.itschool.flightreservation.repository.CityRepository;
import kg.itschool.flightreservation.service.CityService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CityServiceImpl implements CityService {

    @NonNull CityRepository cityRepository;

    City getCityByStateAndName(String state, String city) {
        return cityRepository
                .findCityByStateAndCityName(state, city)
                .orElseThrow(() -> new EntityNotFoundException("City with name=" + city + " and state=" + state + " not found"));
    }

    @Override
    public CityDto create(CreateCityRequest request) {
        City city = City
                .builder()
                .cityName(request.getCityName())
                .lat(request.getLat())
                .lon(request.getLon())
                .state(request.getState())
                .build();
        return CityMapper.INSTANCE.toDto(cityRepository.save(city));
    }
}

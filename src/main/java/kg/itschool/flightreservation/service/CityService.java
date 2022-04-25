package kg.itschool.flightreservation.service;

import kg.itschool.flightreservation.model.dto.CityDto;
import kg.itschool.flightreservation.model.request.CreateCityRequest;
import org.springframework.stereotype.Service;

@Service
public interface CityService {

    CityDto create(CreateCityRequest request);

}

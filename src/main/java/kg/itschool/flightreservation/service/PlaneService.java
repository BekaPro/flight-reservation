package kg.itschool.flightreservation.service;

import kg.itschool.flightreservation.model.dto.PlaneDto;
import kg.itschool.flightreservation.model.request.CreatePlaneRequest;
import org.springframework.stereotype.Service;

@Service
public interface PlaneService {
    PlaneDto create(CreatePlaneRequest request);
}

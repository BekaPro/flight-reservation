package kg.itschool.flightreservation.service;

import kg.itschool.flightreservation.model.entity.Plane;
import org.springframework.stereotype.Service;

@Service
public interface PlaneService {
    Plane create();
}

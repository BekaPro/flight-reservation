package kg.itschool.flightreservation.service;

import kg.itschool.flightreservation.model.dto.SupplierDto;
import kg.itschool.flightreservation.model.request.CreateSupplierRequest;
import org.springframework.stereotype.Service;

@Service
public interface SupplierService {
    SupplierDto create(CreateSupplierRequest request);
}
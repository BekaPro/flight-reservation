package kg.itschool.flightreservation.service;

import kg.itschool.flightreservation.model.entity.Supplier;
import kg.itschool.flightreservation.model.request.CreateSupplierRequest;
import org.springframework.stereotype.Service;

@Service
public interface SupplierService {
    Supplier create(CreateSupplierRequest request);
}
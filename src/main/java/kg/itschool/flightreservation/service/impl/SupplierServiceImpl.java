package kg.itschool.flightreservation.service.impl;

import kg.itschool.flightreservation.model.entity.Supplier;
import kg.itschool.flightreservation.model.request.CreateSupplierRequest;
import kg.itschool.flightreservation.repository.SupplierRepository;
import kg.itschool.flightreservation.service.SupplierService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    @NonNull SupplierRepository supplierRepository;

    @Override
    public Supplier create(CreateSupplierRequest request) {
        Supplier supplier = new Supplier();
        supplier.setSupplierName(request.getSupplierName());
        supplierRepository.save(supplier);
        System.out.println(supplier);
        return supplier;
    }
}

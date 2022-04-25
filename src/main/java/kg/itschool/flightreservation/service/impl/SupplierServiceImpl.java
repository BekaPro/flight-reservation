package kg.itschool.flightreservation.service.impl;

import kg.itschool.flightreservation.exceptions.EntityNotFoundException;
import kg.itschool.flightreservation.model.dto.SupplierDto;
import kg.itschool.flightreservation.model.entity.Supplier;
import kg.itschool.flightreservation.model.mapper.SupplierMapper;
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
    public SupplierDto create(CreateSupplierRequest request) {
        Supplier supplier = new Supplier();
        supplier.setSupplierName(request.getSupplierName());
        return SupplierMapper.INSTANCE
                .toDto(supplierRepository.save(supplier));
    }

    Supplier getSupplierByName(String name) {
        return supplierRepository
                .findSupplierBySupplierName(name)
                .orElseThrow(() -> new EntityNotFoundException("Supplier " + name + " not found"));
    }

}

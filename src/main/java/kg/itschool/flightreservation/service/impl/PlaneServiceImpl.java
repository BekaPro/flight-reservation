package kg.itschool.flightreservation.service.impl;

import kg.itschool.flightreservation.exceptions.EntityNotFoundException;
import kg.itschool.flightreservation.model.dto.PlaneDto;
import kg.itschool.flightreservation.model.entity.Plane;
import kg.itschool.flightreservation.model.mapper.PlaneMapper;
import kg.itschool.flightreservation.model.request.CreatePlaneRequest;
import kg.itschool.flightreservation.repository.PlaneRepository;
import kg.itschool.flightreservation.service.PlaneService;
import kg.itschool.flightreservation.service.SupplierService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaneServiceImpl implements PlaneService {

    @NonNull PlaneRepository planeRepository;
    @NonNull SupplierService supplierService;

    Plane getById(Long id) {
        return planeRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plane with id=" + id + " not found"));
    }

    @Override
    public PlaneDto create(CreatePlaneRequest request) {
        return PlaneMapper.INSTANCE
                .toDto(planeRepository
                        .save(Plane
                                .builder()
                                .supplier(((SupplierServiceImpl) supplierService).getSupplierByName(request.getSupplier()))
                                .capacity(request.getCapacity())
                                .model(request.getModel())
                                .build()));
    }
}

package kg.itschool.flightreservation.model.mapper;

import kg.itschool.flightreservation.model.dto.CustomerDto;
import kg.itschool.flightreservation.model.entity.Customer;

import java.util.List;

public interface BaseMapper<ENTITY, DTO> {
    ENTITY toEntity(DTO dto);
    DTO toDto(ENTITY entity);
    List<DTO> toDtoList(List<ENTITY> entities);
    List<ENTITY> toEntityList(List<DTO> dtos);
}

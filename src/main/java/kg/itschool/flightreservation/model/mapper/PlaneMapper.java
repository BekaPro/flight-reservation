package kg.itschool.flightreservation.model.mapper;

import kg.itschool.flightreservation.model.dto.PlaneDto;
import kg.itschool.flightreservation.model.entity.Plane;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlaneMapper extends BaseMapper<Plane, PlaneDto> {
    PlaneMapper INSTANCE = Mappers.getMapper(PlaneMapper.class);
}

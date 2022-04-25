package kg.itschool.flightreservation.model.mapper;

import kg.itschool.flightreservation.model.dto.FlightDto;
import kg.itschool.flightreservation.model.entity.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FlightMapper extends BaseMapper<Flight, FlightDto> {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);
}

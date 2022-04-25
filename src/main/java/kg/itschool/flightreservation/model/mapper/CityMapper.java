package kg.itschool.flightreservation.model.mapper;

import kg.itschool.flightreservation.model.dto.CityDto;
import kg.itschool.flightreservation.model.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper extends BaseMapper<City, CityDto> {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
}

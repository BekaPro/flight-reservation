package kg.itschool.flightreservation.model.mapper;

import kg.itschool.flightreservation.model.dto.SupplierDto;
import kg.itschool.flightreservation.model.entity.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SupplierMapper extends BaseMapper<Supplier, SupplierDto> {
   SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);
}

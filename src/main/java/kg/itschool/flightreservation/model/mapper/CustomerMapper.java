package kg.itschool.flightreservation.model.mapper;

import kg.itschool.flightreservation.model.dto.CustomerDto;
import kg.itschool.flightreservation.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer, CustomerDto>{
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
}

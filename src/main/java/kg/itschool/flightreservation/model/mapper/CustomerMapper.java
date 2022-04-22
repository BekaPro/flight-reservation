package kg.itschool.flightreservation.model.mapper;

import kg.itschool.flightreservation.model.dto.CustomerDto;
import kg.itschool.flightreservation.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toEntity(CustomerDto customerDto);
    CustomerDto toDto(Customer customer);
    List<CustomerDto> toDtoList(List<Customer> customerList);
    List<Customer> toEntityList(List<CustomerDto> customerDtoList);
}

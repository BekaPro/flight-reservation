package kg.itschool.flightreservation.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCustomerRequest {
    String name;
    BigDecimal funds;
}

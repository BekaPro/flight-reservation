package kg.itschool.flightreservation.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SupplierDto implements Serializable {

    Long id;
    String supplierName;

    @JsonIgnore
    LocalDateTime dateCreated;

    @JsonIgnore
    LocalDateTime dateUpdated;
}

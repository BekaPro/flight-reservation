package kg.itschool.flightreservation.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.itschool.flightreservation.model.dto.WalletDto;
import kg.itschool.flightreservation.model.entity.Flight;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomerDto implements Serializable {
    Long id;
    String email;
    String firstName;
    String lastName;
    String patronymic;
    String fullName;
    String phoneNumber;
    WalletDto wallet;

    @JsonIgnore
    LocalDateTime dateCreated;

    @JsonIgnore
    LocalDateTime dateUpdated;
}

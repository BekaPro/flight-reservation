package kg.itschool.flightreservation.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "tb_wallets")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Wallet extends BaseEntity {

    @Column(name = "funds", columnDefinition = "NUMERIC DEFAULT 0")
    BigDecimal funds;

}

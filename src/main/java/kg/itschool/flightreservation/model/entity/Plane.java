package kg.itschool.flightreservation.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "tb_planes")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plane extends BaseEntity {

    @Column(name = "model", nullable = false, length = 100)
    String model;

    @Column(name = "capacity", nullable = false)
    Integer capacity;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    Supplier supplier;

}

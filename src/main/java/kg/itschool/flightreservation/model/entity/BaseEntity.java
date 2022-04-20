package kg.itschool.flightreservation.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "date_created", nullable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    LocalDateTime dateCreated;

    @Column(name = "date_update", nullable = false, columnDefinition = "TIMESTAMP")
    LocalDateTime dateUpdated;

    @PostConstruct
    private void onCreate() {
        dateCreated = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate() {
        dateUpdated = LocalDateTime.now();
    }
}
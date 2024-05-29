package uz.imed.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String phone;

    String firstname;

    String surname;

    String lastname;

    Long polyclinicId;

    @OneToOne
    Address address;

    boolean access;
}

package uz.imed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.imed.entity.Patient;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long>
{
    Optional<Patient> findById(long id);
    Optional<Patient> findByPhone(String phone);
    Boolean existsById(long id);
    Boolean existsByPhone(String phone);

}

package uz.imed.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.imed.entity.Patient;
import uz.imed.exception.PatientNotFoundException;
import uz.imed.exception.PatientNotSavedException;
import uz.imed.feign.PolyclinicFeign;
import uz.imed.mapper.PatientMapper;
import uz.imed.model.PatientDto;
import uz.imed.repository.PatientRepository;

import java.util.Optional;

@RequiredArgsConstructor

@Service
public class PatientService
{
    private final PatientRepository patientRepo;
    private final PatientMapper patientMapper;
//    private final PolyclinicFeign polyclinicFeign;

    public ResponseEntity<PatientDto> findById(long id)
    {
        Optional<Patient> patient = patientRepo.findById(id);
        if (patient.isEmpty())
            throw new PatientNotFoundException("Patient not found by id :" + id);

        PatientDto dto = patientMapper.toDto(patient.get());
        return ResponseEntity.ok().body(dto);
    }


    public ResponseEntity<PatientDto> create(PatientDto patientDto)
    {
        Patient patient = patientMapper.toEntity(patientDto);
        patientRepo.save(patient);
        return ResponseEntity.ok().body(patientMapper.toDto(patient));
    }

    public ResponseEntity<PatientDto> update(String phone, PatientDto patientDto)
    {
        Optional<Patient> optional = patientRepo.findByPhone(phone);
        if (optional.isEmpty())
            throw new PatientNotFoundException("Patient not found by phone :" + phone);
        try
        {
            Patient fromDb = optional.get();
            Patient newEntity = patientMapper.toEntity(patientDto);
            newEntity.setId(fromDb.getId());
            Patient newSavedEntity = patientRepo.save(newEntity);
            return ResponseEntity.ok().body(patientMapper.toDto(newSavedEntity));
        }catch (RuntimeException e)
        {
            throw new PatientNotSavedException("Patient not saved :" + e.getMessage());
        }
    }

    public ResponseEntity<?> deleteById(long id)
    {
        if (!patientRepo.existsById(id))
            throw new PatientNotFoundException("Patient not found by id :" + id);

        patientRepo.deleteById(id);
        return ResponseEntity.ok().body("Patient deleted");
    }


    public ResponseEntity<Boolean> checkRegistered(String phone)
    {
//        ResponseEntity<Boolean> check = polyclinicFeign.check(phone);
//        Boolean body = check.getBody();
        return ResponseEntity.ok(true);
    }

}

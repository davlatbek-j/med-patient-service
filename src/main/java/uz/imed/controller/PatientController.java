package uz.imed.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.imed.model.PatientDto;
import uz.imed.service.PatientService;

@RequiredArgsConstructor

@RestController
@RequestMapping("/patient")
public class PatientController
{
    private final PatientService patientService;

    @GetMapping("get/{id}")
    public ResponseEntity<PatientDto> getPatient(@PathVariable long id)
    {
        return patientService.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<PatientDto> create(@RequestBody PatientDto patientDto)
    {
        return patientService.create(patientDto);
    }

    @PutMapping("/update/{phone}")
    public ResponseEntity<PatientDto> update(@PathVariable String phone , @RequestBody PatientDto patientDto)
    {
        return patientService.update(phone , patientDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id)
    {
        return patientService.deleteById(id);
    }

    @GetMapping("/isRegistered")
    public ResponseEntity<Boolean> isRegistered(@RequestBody String phone)
    {
        return patientService.checkRegistered(phone);
    }

}

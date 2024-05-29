package uz.imed.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.imed.entity.Patient;
import uz.imed.model.PatientDto;


@RequiredArgsConstructor

@Component
public class PatientMapper
{

    private final AddressMapper addressMapper;

    public Patient toEntity(PatientDto dto)
    {
        Patient entity = new Patient();
        entity.setPhone(dto.getPhone());
        entity.setFirstname(dto.getFirstname());
        entity.setLastname(dto.getLastname());
        entity.setSurname(dto.getSurname());
        entity.setPolyclinicId(dto.getPolyclinicId());
        entity.setAddress(addressMapper.toEntity(dto.getAddress()));
        entity.setAccess(true);
        return entity;
    }

    public PatientDto toDto(Patient entity)
    {
        PatientDto dto = new PatientDto();
        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        dto.setFirstname(entity.getFirstname());
        dto.setSurname(entity.getSurname());
        dto.setLastname(entity.getLastname());
        dto.setAddress(addressMapper.toDto(entity.getAddress()));
        dto.setPolyclinicId(entity.getPolyclinicId());
        return dto;
    }
}

package uz.imed.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uz.imed.entity.Address;
import uz.imed.model.AddressDto;

@Component
public class AddressMapper {

    public Address toEntity(AddressDto dto) {
        Address address = new Address();
        address.setDistrict(dto.getDistrict());
        address.setKvartal(dto.getKvartal());
        address.setDom(dto.getDom());
        address.setUy(dto.getUy());
        address.setStreet(dto.getStreet());
        return address;
    }
    public AddressDto toDto(Address entity) {
        AddressDto dto = new AddressDto();
        dto.setId(entity.getId());
        dto.setDistrict(entity.getDistrict());
        dto.setKvartal(entity.getKvartal());
        dto.setDom(entity.getDom());
        dto.setUy(entity.getUy());
        dto.setStreet(entity.getStreet());
        return dto;
    }
}

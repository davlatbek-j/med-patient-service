package uz.imed.feign;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.imed.model.PatientDto;

//@Component
public interface PolyclinicFeign
{
    @GetMapping("/polyclinic/check/{phone}")
    public ResponseEntity<Boolean> check(@PathVariable String phone);

}

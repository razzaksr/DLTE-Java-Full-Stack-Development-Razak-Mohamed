package crud.hibernate.jpa.dltehibernatejpa.controls;

import crud.hibernate.jpa.dltehibernatejpa.model.BankEmployee;
import crud.hibernate.jpa.dltehibernatejpa.services.BankEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/banker")
public class BankEmployeeController {
    @Autowired
    BankEmployeeService service;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public BankEmployee callCreate(@RequestBody BankEmployee bankEmployee){
        bankEmployee.setPassword(passwordEncoder.encode(bankEmployee.getPassword()));
        return service.create(bankEmployee);
    }
}

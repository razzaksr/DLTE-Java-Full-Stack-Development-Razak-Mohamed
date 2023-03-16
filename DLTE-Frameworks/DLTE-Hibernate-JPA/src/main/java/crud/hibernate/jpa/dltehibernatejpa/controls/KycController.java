package crud.hibernate.jpa.dltehibernatejpa.controls;

import crud.hibernate.jpa.dltehibernatejpa.model.KnowYourCustomer;
import crud.hibernate.jpa.dltehibernatejpa.services.KycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KycController {
    @Autowired
    private KycService kycService;

    @PostMapping("/insert")
    public KnowYourCustomer callingSave(@RequestBody KnowYourCustomer knowYourCustomer){
        return kycService.implementationOfSave(knowYourCustomer);
    }
}

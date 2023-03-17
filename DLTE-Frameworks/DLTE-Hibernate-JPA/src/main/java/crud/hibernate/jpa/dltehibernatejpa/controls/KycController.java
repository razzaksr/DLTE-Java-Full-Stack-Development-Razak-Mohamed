package crud.hibernate.jpa.dltehibernatejpa.controls;

import crud.hibernate.jpa.dltehibernatejpa.model.KnowYourCustomer;
import crud.hibernate.jpa.dltehibernatejpa.services.KycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class KycController {
    @Autowired
    private KycService kycService;

    @GetMapping("/aadhaar")
    public List<Long> callToFetchAadhaar(){
        return kycService.implementFetchAadhaar();
    }

    @GetMapping("/min/{balance}")
    public List<KnowYourCustomer> callMinimumBalance(@PathVariable("balance") double balance){
        return kycService.implementMinimumBalance(balance);
    }

    @GetMapping("/perfect/{balance}")
    public List<KnowYourCustomer> callBalanceExact(@PathVariable("balance") double balance){
        return kycService.implementOfExactBalance(balance);
    }

    @GetMapping("/pancard/{pan}")
    public Optional<KnowYourCustomer> callFetchPan(@PathVariable("pan") String pan){
        return kycService.implementOfPan(pan);
    }

    @PutMapping("/change")
    public KnowYourCustomer callUpdate(@RequestBody KnowYourCustomer knowYourCustomer){
        return kycService.implementationOfSave(knowYourCustomer);
    }

    @DeleteMapping("/suspend/{accountNumber}")
    public String callDeleteById(@PathVariable("accountNumber") long accountNumber){
        return kycService.implementOfDeleteById(accountNumber);
    }

    @GetMapping("/account/{accountNumber}")
    public Optional<KnowYourCustomer> callingFindById(@PathVariable("accountNumber") long accountNumber){
        return kycService.implementOfFindById(accountNumber);
    }

    @GetMapping("/retrieve")
    public List<KnowYourCustomer> callingFindAll(){
        return kycService.implementOfFindAll();
    }

    @PostMapping("/insert")
    public KnowYourCustomer callingSave(@RequestBody KnowYourCustomer knowYourCustomer){
        return kycService.implementationOfSave(knowYourCustomer);
    }
}

package relations.jpa.dltespringjparelations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relations.jpa.dltespringjparelations.entities.Customers;
import relations.jpa.dltespringjparelations.entities.Payees;
import relations.jpa.dltespringjparelations.services.CustomersService;
import relations.jpa.dltespringjparelations.services.PayeesService;

import java.util.List;

@RestController
public class PayeeModule {
    @Autowired
    private CustomersService customersService;

    @Autowired
    private PayeesService payeesService;

    @GetMapping("/mylist/{number}")
    public List<Payees> callPayeeListCustomer(@PathVariable("number") long number){
        Customers customers=customersService.implementFindId(number).get();
        return payeesService.implementByCustomer(customers);
    }

    @PostMapping("/add/{number}")
    public Payees callPayeeSave(@PathVariable("number") long number, @RequestBody Payees payees){
        Customers customers=customersService.implementFindId(number).get();
        // third table
        customers.getMyBeneficiary().add(payees);
        // assign the customer in the payee table to which payee has added
        payees.setCustomer(customers);
        return payeesService.implementSavePayee(payees);
    }

    @PostMapping("/newkyc")
    public Customers callSave(@RequestBody Customers customers){
        return customersService.implementSave(customers);
    }
}

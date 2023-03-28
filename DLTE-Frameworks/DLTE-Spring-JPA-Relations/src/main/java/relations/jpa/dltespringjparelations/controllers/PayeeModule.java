package relations.jpa.dltespringjparelations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relations.jpa.dltespringjparelations.entities.Customers;
import relations.jpa.dltespringjparelations.entities.Payees;
import relations.jpa.dltespringjparelations.services.CustomersService;
import relations.jpa.dltespringjparelations.services.PayeesService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class PayeeModule {
    @Autowired
    private CustomersService customersService;
    @Autowired
    private PayeesService payeesService;

    @DeleteMapping("/removePayee/{number}/{id}")
    public String callDeletePayee(@PathVariable("number")long number,@PathVariable("id") int id){
        //return payeesService.implementDelete(id);
        Customers customers=customersService.implementFindId(number).get();
        Payees payees=payeesService.implementByCustomerAndPayee(number,id).get();
        List<Payees> tempList=customers.getMyBeneficiary();
        tempList.remove(payees);
        customers.setMyBeneficiary(tempList);
        customersService.implementSave(customers);
        return payeesService.implementDelete(id);
    }

    @PutMapping("/updateCustomer")
    public Customers callCustomerUpdate(@RequestBody Customers customers){
        return customersService.implementSave(customers);
    }

    @PutMapping("/updateOne/{number}")
    public Payees callPayeeUpdate(@PathVariable("number") long number, @RequestBody Payees payees){
        Customers customers=customersService.implementFindId(number).get();
        // third table
        List<Payees> tempList=customers.getMyBeneficiary();
        for(int index=0;index< tempList.size();index++){
            if(tempList.get(index).getBeneficiaryId()== payees.getBeneficiaryId()){
                tempList.set(index,payees);
            }
        }
        // update the beneficiary list of the customer
        customers.setMyBeneficiary(tempList);
        payees.setCustomer(customers);
        //System.out.println(payees);
        customersService.implementSave(customers);
        // assign the customer in the payee table to which payee has added
        return payeesService.implementSavePayee(payees);
    }

    @GetMapping("/find/{customerId}/{payeeId}")
    public Optional<Payees> callImplementCustomerPayee(@PathVariable("customerId") long customerId,@PathVariable("payeeId") int payeeId){
        return payeesService.implementByCustomerAndPayee(customerId,payeeId);
    }

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

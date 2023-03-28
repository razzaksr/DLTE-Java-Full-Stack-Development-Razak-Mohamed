package relations.jpa.dltespringjparelations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relations.jpa.dltespringjparelations.entities.Customers;
import relations.jpa.dltespringjparelations.entities.Payees;
import relations.jpa.dltespringjparelations.repos.PayeesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PayeesService {
    @Autowired
    PayeesRepository repository;

    public Optional<Payees> implementByCustomerAndPayee(long customerId,int payeeId){
        return repository.findPayeeByCustomer(customerId,payeeId);
    }

    public List<Payees> implementByCustomer(Customers customers){
        return repository.findAllByCustomer(customers);
    }

    public Payees implementSavePayee(Payees payees){
        return repository.save(payees);
    }

    public String implementDelete(int id){
        String name=repository.getById(id).getBeneficiaryName()+" has deleted";
        repository.deleteOnlyPayee(id);
        return name;
    }
}

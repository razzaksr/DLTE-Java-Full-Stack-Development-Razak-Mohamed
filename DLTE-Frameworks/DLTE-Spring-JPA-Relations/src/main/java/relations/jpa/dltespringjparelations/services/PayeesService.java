package relations.jpa.dltespringjparelations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relations.jpa.dltespringjparelations.entities.Customers;
import relations.jpa.dltespringjparelations.entities.Payees;
import relations.jpa.dltespringjparelations.repos.PayeesRepository;

import java.util.List;

@Service
public class PayeesService {
    @Autowired
    PayeesRepository repository;

    public List<Payees> implementByCustomer(Customers customers){
        return repository.findAllByCustomer(customers);
    }

    public Payees implementSavePayee(Payees payees){
        return repository.save(payees);
    }
}

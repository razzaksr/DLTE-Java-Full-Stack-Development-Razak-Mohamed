package relations.jpa.dltespringjparelations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relations.jpa.dltespringjparelations.entities.Customers;
import relations.jpa.dltespringjparelations.entities.Payees;
import relations.jpa.dltespringjparelations.repos.CustomersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {
    @Autowired
    CustomersRepository repository;

    public Optional<Customers> implementFindId(long id){
        return repository.findById(id);
    }

    public Customers implementSave(Customers customers){
        return repository.save(customers);
    }
}

package crud.hibernate.jpa.dltehibernatejpa.services;

import crud.hibernate.jpa.dltehibernatejpa.model.KnowYourCustomer;
import crud.hibernate.jpa.dltehibernatejpa.remote.KycRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KycService {
    @Autowired
    private KycRepository repository;

    public String implementOfDeleteById(long accountNumber){
        KnowYourCustomer knowYourCustomer=repository.findById(accountNumber).get();
        String information= knowYourCustomer.getAccountHolder()+" has removed/suspended";
        repository.deleteById(accountNumber);
        return information;
    }

    public Optional<KnowYourCustomer> implementOfFindById(long accountNumber){
        return repository.findById(accountNumber);
    }

    public List<KnowYourCustomer> implementOfFindAll(){
        return (List<KnowYourCustomer>) repository.findAll();
    }

    public KnowYourCustomer implementationOfSave(KnowYourCustomer knowYourCustomer){
        return repository.save(knowYourCustomer);
    }
}

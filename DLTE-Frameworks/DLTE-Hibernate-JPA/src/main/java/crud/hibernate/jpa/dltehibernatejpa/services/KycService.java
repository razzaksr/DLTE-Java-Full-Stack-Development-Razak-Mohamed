package crud.hibernate.jpa.dltehibernatejpa.services;

import crud.hibernate.jpa.dltehibernatejpa.model.KnowYourCustomer;
import crud.hibernate.jpa.dltehibernatejpa.remote.KycRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KycService {
    @Autowired
    private KycRepository repository;
    public KnowYourCustomer implementationOfSave(KnowYourCustomer knowYourCustomer){
        return repository.save(knowYourCustomer);
    }
}

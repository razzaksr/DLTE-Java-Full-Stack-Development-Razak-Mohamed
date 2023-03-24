package crud.hibernate.jpa.dltehibernatejpa.services;

import crud.hibernate.jpa.dltehibernatejpa.model.BankEmployee;
import crud.hibernate.jpa.dltehibernatejpa.remote.BankerEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BankEmployeeService implements UserDetailsService {
    @Autowired
    private BankerEmployeeRepository repository;

    public BankEmployee create(BankEmployee bankEmployee){
        return repository.save(bankEmployee);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BankEmployee employee=repository.findByUsername(username);
        if(employee==null){
            return (UserDetails) new UsernameNotFoundException("Invalid Username entered");
        }
        return employee;
    }
}

package crud.hibernate.jpa.dltehibernatejpa.remote;

import crud.hibernate.jpa.dltehibernatejpa.model.BankEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankerEmployeeRepository extends JpaRepository<BankEmployee,Integer> {
    BankEmployee findByUsername(String username);
}

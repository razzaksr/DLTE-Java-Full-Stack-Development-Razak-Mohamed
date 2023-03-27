package relations.jpa.dltespringjparelations.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import relations.jpa.dltespringjparelations.entities.Customers;
import relations.jpa.dltespringjparelations.entities.Payees;

import java.util.List;

@Repository
public interface PayeesRepository extends JpaRepository<Payees,Integer> {
    List<Payees> findAllByCustomer(Customers customers);
}

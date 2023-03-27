package relations.jpa.dltespringjparelations.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import relations.jpa.dltespringjparelations.entities.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers,Long> {

}

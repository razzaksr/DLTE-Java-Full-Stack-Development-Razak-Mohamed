package relations.jpa.dltespringjparelations.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import relations.jpa.dltespringjparelations.entities.Customers;
import relations.jpa.dltespringjparelations.entities.Payees;

import java.util.List;
import java.util.Optional;

@Repository
public interface PayeesRepository extends JpaRepository<Payees,Integer> {
    @Transactional
    @Modifying
    @Query(value="delete from payees where beneficiary_id=?1",nativeQuery = true)
    void deleteOnlyPayee(int payeeId);
    @Query(value = "select * from payees where customer_id=?1 and beneficiary_id=?2",nativeQuery = true)
    Optional<Payees> findPayeeByCustomer(long customerId,int payeeId);
    List<Payees> findAllByCustomer(Customers customers);
}

package crud.hibernate.jpa.dltehibernatejpa.remote;

import crud.hibernate.jpa.dltehibernatejpa.model.KnowYourCustomer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KycRepository extends CrudRepository<KnowYourCustomer,Long> {
    @Query("Select aadhaar from KnowYourCustomer")
    List<Long> findAllAadhaar();
    @Query("from KnowYourCustomer where accountBalance>= :balance")
    List<KnowYourCustomer> findAllByMinimumBalance(double balance);
    List<KnowYourCustomer> findAllByAccountBalance(double balance);
    Optional<KnowYourCustomer> findByPan(String pan);
}

package crud.hibernate.jpa.dltehibernatejpa.remote;

import crud.hibernate.jpa.dltehibernatejpa.model.KnowYourCustomer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface KycRepository extends CrudRepository<KnowYourCustomer,Long> {
    @Query(value="select * from know_your_customer where date_of_creation<=?1",nativeQuery = true)
    List<KnowYourCustomer> fetchAllEarlierDate(String date);
    @Modifying
    @Transactional
    @Query("delete from KnowYourCustomer where address like %:location%")
    void deleteAllByLocation(String location);

    @Query("Select accountHolder from KnowYourCustomer where address like %:location%")
    List<String> findAllByLocation(String location);

    @Modifying
    @Transactional
    @Query("update KnowYourCustomer set accountBalance=accountBalance-(accountBalance*0.100) where accountBalance<10000")
    void updateOnBalance();
    @Query("Select aadhaar from KnowYourCustomer")
    List<Long> findAllAadhaar();
    @Query("from KnowYourCustomer where accountBalance>= :balance")
    List<KnowYourCustomer> findAllByMinimumBalance(double balance);
    List<KnowYourCustomer> findAllByAccountBalance(double balance);
    Optional<KnowYourCustomer> findByPan(String pan);
}

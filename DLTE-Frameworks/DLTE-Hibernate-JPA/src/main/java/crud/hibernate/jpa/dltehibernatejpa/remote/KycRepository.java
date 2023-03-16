package crud.hibernate.jpa.dltehibernatejpa.remote;

import crud.hibernate.jpa.dltehibernatejpa.model.KnowYourCustomer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KycRepository extends CrudRepository<KnowYourCustomer,Long> {
}

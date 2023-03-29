package soap.dlte.web.dltespringsoapwebservice.hibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficialsRepository extends JpaRepository<OfficialsPojo,Integer> {
}

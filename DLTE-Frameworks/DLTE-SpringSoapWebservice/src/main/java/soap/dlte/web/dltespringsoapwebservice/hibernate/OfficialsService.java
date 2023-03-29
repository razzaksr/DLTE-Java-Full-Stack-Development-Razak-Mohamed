package soap.dlte.web.dltespringsoapwebservice.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
//@Transactional
public class OfficialsService {
    @Autowired
    private OfficialsRepository repository;

    public OfficialsPojo create(OfficialsPojo officials){
        return repository.save(officials);
    }
}

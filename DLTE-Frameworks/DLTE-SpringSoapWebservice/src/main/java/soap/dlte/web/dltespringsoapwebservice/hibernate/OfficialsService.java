package soap.dlte.web.dltespringsoapwebservice.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class OfficialsService {
    @Autowired
    private OfficialsRepository repository;

    public String remove(int id){
        String info=read(id).getFullName()+" has deleted";
        repository.deleteById(id);
        return info;
    }

    public OfficialsPojo read(int id){
        return repository.findById(id).get();
    }

    public List<OfficialsPojo> list(){
        return repository.findAll();
    }

    public OfficialsPojo create(OfficialsPojo officials){
        return repository.save(officials);
    }
}

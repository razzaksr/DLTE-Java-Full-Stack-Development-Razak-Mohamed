package data.jdbc.dlte.dltespringjdbctemplates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/template") // http://localhost8082/template/urls
public class BankersController {

    @Autowired
    private BankersService service;

    private Logger logger= LoggerFactory.getLogger(BankersController.class);

    @DeleteMapping("/{id}")
    public String callDelete(@PathVariable("id") int id){
        logger.error("Controller about to delete record based on "+id);
        return service.deleteOne(id);
    }

    @PutMapping("/")
    public String callUpdate(@RequestBody Bankers bankers){
        logger.info(bankers.getBankerId()+" has trying to update the profile");
        return service.updateOne(bankers);
    }

    @GetMapping("/byname/{name}")
    public List<Bankers> callReadByName(@PathVariable("name") String name){
        logger.warn("Through the name of "+name+" controller trying to find the records");
        return service.readNames(name);
    }

    @PostMapping("/")
    public String adding(@RequestBody Bankers bankers){
        logger.trace(bankers.getBankerName()+" has trying to get access in savincred bank");
        return service.insertion(bankers);
    }

    @GetMapping("/{id}")
    public Optional<Bankers> callOneId(@PathVariable("id") int id){
        logger.debug("Controller about to find record matches with "+id);
        return service.listOne(id);
    }

    @GetMapping("/")
    public List<Bankers> callList(){
        logger.info("Controller about print All the records");
        return service.listAll();
    }
}

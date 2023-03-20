package data.jdbc.dlte.dltespringjdbctemplates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/template") // http://localhost8082/template/urls
public class BankersController {
    @Autowired
    private BankersService service;

    @DeleteMapping("/{id}")
    public String callDelete(@PathVariable("id") int id){
        return service.deleteOne(id);
    }

    @PutMapping("/")
    public String callUpdate(@RequestBody Bankers bankers){
        return service.updateOne(bankers);
    }

    @GetMapping("/byname/{name}")
    public List<Bankers> callReadByName(@PathVariable("name") String name){
        return service.readNames(name);
    }

    @PostMapping("/")
    public String adding(@RequestBody Bankers bankers){
        return service.insertion(bankers);
    }

    @GetMapping("/{id}")
    public Optional<Bankers> callOneId(@PathVariable("id") int id){
        return service.listOne(id);
    }

    @GetMapping("/")
    public List<Bankers> callList(){
        return service.listAll();
    }
}

package data.jdbc.dlte.dltespringjdbctemplates;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class MvcController {

    @GetMapping("/")
    public String basic(){
        return "index";
    }
}

package viikko2.hello_thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class Thymeleaf_controller {

    @GetMapping("hello")
    public String showMessage(@RequestParam String name, @RequestParam int age, Model model) {

        model.addAttribute("name", name);
        model.addAttribute("age", age);
        
        return "hello";
    }
    
    

}

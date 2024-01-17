package viikko1.request_parameters.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("hello")
    @ResponseBody
    public String returnLocationAndName (
    @RequestParam (name="location", required = false, defaultValue = "Unknown") String location,
    @RequestParam (name="name", required = false, defaultValue = "Stranger") String name) {
        return "Welcome to the " + location + " " + name + "!";
    }
}

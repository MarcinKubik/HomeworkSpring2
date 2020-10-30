package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/first")
    public String goToFirstJsp(){
        return "first";
    }

    @GetMapping("/third")
    public String goToThirdJsp(){
        return "third";
    }

    @GetMapping("/second")
    public String redirecttoThird(){
        return "redirect:third";
    }
}

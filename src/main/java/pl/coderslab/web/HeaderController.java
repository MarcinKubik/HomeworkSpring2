package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class HeaderController {

    @GetMapping("/showUserAgent")
    public String showUserAgent(@RequestHeader("User-Agent") String useragent, Model model){
        model.addAttribute("useragent", useragent);
        return "userAgent";
    }
}

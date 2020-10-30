package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"cookies"})
public class CookieController {

    @GetMapping("/add-cookies")
    public void addCookies(HttpServletResponse response){
        Cookie cookie1 = new Cookie("user", "Jan");
        Cookie cookie2 = new Cookie("uid", "ccb1b154-c4ff");
        Cookie cookie3 = new Cookie("IDE", "Intellij");
        cookie1.setMaxAge(600);
        cookie2.setMaxAge(864000);
        cookie3.setMaxAge(30 * 86400);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
    }

    @GetMapping("/all-cookies")
    public String getCookies(HttpServletRequest request, Model model){
        List<Cookie> cookies = new ArrayList<>();
        Cookie cookie1 = WebUtils.getCookie(request, "user");
        Cookie cookie2 = WebUtils.getCookie(request, "uid");
        Cookie cookie3 = WebUtils.getCookie(request, "IDE");
        cookies.add(cookie1);
        cookies.add(cookie2);
        cookies.add(cookie3);
        model.addAttribute("cookies", cookies);
        return "showCookies";
    }

}

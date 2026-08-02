package org.example.tliaswebmanagement.Controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.EntityClass.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class SessionController {

    @GetMapping("/s1")
    public Result setCookie(HttpServletResponse res){
        res.addCookie(new Cookie("token","123456"));
        return Result.Success();
    }

    @GetMapping("/s2")
    public Result getCookie(HttpServletRequest rqs){
        Cookie[] cookies = rqs.getCookies();
        for(Cookie cookie:cookies) {
            if (cookie.getName().equals("token")) {
                System.out.println(cookie.getValue());
            }
        }
        return Result.Success();
    }

    @GetMapping("/s3")
    public Result setSession(HttpSession session){
        session.setAttribute("name","lhx");
        log.info("s1->{}",session.hashCode());
        return Result.Success();
    }

    @GetMapping("/s4")
    public Result getSession(HttpSession session){
        Object data = session.getAttribute("name");
        log.info("s2->{}",session.hashCode());
        log.info("data->{}",data);
        return Result.Success();
    }
}

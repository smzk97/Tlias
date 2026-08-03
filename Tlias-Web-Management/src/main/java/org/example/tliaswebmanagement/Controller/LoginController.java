package org.example.tliaswebmanagement.Controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.EntityClass.Employee;
import org.example.tliaswebmanagement.EntityClass.LoginInfo;
import org.example.tliaswebmanagement.EntityClass.Result;
import org.example.tliaswebmanagement.Service.DepartmentService;
import org.example.tliaswebmanagement.Service.EmployeeService;
import org.example.tliaswebmanagement.Service.Ipl.DepartmentServiceIpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    private EmployeeService employeeService;
    @Autowired
    public LoginController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

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

    @PostMapping("")
    public Result LoginVerify(@RequestBody Employee employee){
        LoginInfo loginInfo = employeeService.LoginVerify(employee);
        if(loginInfo != null){
            return Result.Success(loginInfo);
        }
        return Result.Defeat("用户名或者密码错误");
    }
}

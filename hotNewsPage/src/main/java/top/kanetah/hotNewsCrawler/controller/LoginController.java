package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.kanetah.hotNewsCrawler.service.LoginService;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * created by kane on 2017/11/6.
 */
@Controller("loginController")
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(
            @RequestParam String name,
            @RequestParam String password,
            HttpServletResponse response
    ) {
        if (loginService.login(name, password)) {
            Cookie cookie = new Cookie("name", name);
            cookie.setMaxAge(24 * 60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "success";
        } else
            return "fail";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(
            @RequestParam String name
    ) {
        return loginService.logout(name) ?
                "success" : "fail";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(
            @RequestParam String name,
            @RequestParam String password
    ) {
        return loginService.register(name, password) ?
                "success" : "fail";
    }
}

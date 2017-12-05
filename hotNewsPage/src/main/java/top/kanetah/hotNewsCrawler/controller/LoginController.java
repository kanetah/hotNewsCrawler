package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sdk.BackstageConfig;
import sdk.GeetestLib;
import top.kanetah.hotNewsCrawler.service.LoginService;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

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
    public void logout(
            @RequestParam String name,
            HttpServletResponse response
    ) {
        if (!loginService.logout(name))
            return;
        Cookie cookie = new Cookie("name", "");
        cookie.setPath("/");
        response.addCookie(cookie);
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

    @RequestMapping("/backLogin")
    @ResponseBody
    public String backLogin(
            @RequestParam String password,
            @RequestParam String challenge,
            @RequestParam String validate,
            @RequestParam String seccode,
            HttpServletRequest request
    ) throws IOException {
        return loginService.backstageLogin(password, challenge, validate, seccode, request);
    }

    @RequestMapping("/startCaptcha")
    @ResponseBody
    public void startCaptcha(
            HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        loginService.startCaptcha(request, response);
    }
}

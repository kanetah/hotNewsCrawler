package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kanetah.hotNewsCrawler.service.LoginService;

import javax.annotation.Resource;

/**
 * created by kane on 2017/11/6.
 */
@Controller("loginController")
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(
            @RequestParam String name,
            @RequestParam String password
    ) {
        return loginService.login(name, password) ?
                "index" : "login";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(
            @RequestParam String name
    ) {
        return loginService.logout(name) ?
                "success" : "fail";
    }

    @RequestMapping("/sign")
    @ResponseBody
    public String sign(
            @RequestParam String name,
            @RequestParam String password
    ) {
        return loginService.sign(name, password) ?
                "success" : "fail";
    }
}

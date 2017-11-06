package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.kanetah.hotNewsCrawler.service.LoginService;

import javax.annotation.Resource;

/**
 * created by kane on 2017/11/6.
 */
@Controller("loginController")
@RequestMapping("/")
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(
            @PathVariable String name,
            @PathVariable String password
    ) {
        return loginService.login(name, password) ?
                "index" : "login";
    }
}

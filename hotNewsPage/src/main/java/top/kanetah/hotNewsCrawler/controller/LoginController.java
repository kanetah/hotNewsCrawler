package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.kanetah.hotNewsCrawler.service.LoginService;

import javax.annotation.Resource;

/**
 * created by kane on 2017/11/6.
 */
@Controller("loginController")
@SessionAttributes("name")
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(
            @RequestParam String name,
            @RequestParam String password,
            ModelMap model
    ) {
        if (loginService.login(name, password)) {
            model.addAttribute("name", name);
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

    @RequestMapping(value = "username")
    @ResponseBody
    public String getUsername(@ModelAttribute("name") String name) {
        return name.length() == 0 ? "null" : name;
    }
}

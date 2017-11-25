package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kanetah.hotNewsCrawler.dto.UserDTO;
import top.kanetah.hotNewsCrawler.service.UserService;

import javax.annotation.Resource;
import java.util.List;

@Controller("backstageController")
public class BackstageController {

    @Resource
    private UserService userService;

    @RequestMapping("/back")
    public String backstagePage(){
        return "Backstage";
    }

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }
}

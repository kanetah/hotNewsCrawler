package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kanetah.hotNewsCrawler.dto.UserDTO;
import top.kanetah.hotNewsCrawler.service.BackstageService;

import javax.annotation.Resource;
import java.util.List;

@Controller("backstageController")
public class BackstageController {

    @Resource
    private BackstageService backstageService;

    @RequestMapping("/back")
    public String backstagePage(){
        return "Backstage";
    }

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public List<UserDTO> getAllUsers(){
        return backstageService.getAllUsers();
    }

    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public String updateUserInfo(
            @RequestParam int id,
            @RequestParam String name
    ){
            return backstageService.updateUserInfo(id, name)? "success" : "fail";
    }

    @RequestMapping("/deleteUserByName")
    @ResponseBody
    public String deleteUserByName(
            @RequestParam String name
    ){
                return backstageService.deleteUserByName(name)? "success" : "fail";
    }

    @RequestMapping("/deleteAllUsers")
    @ResponseBody
    public String deleteAllUsers(){
        return backstageService.deleteAllUsers()? "success" : "fail";
    }

    @RequestMapping("/insertUsers")
    @ResponseBody
    public String insertUser(
            @RequestParam String name,
            @RequestParam String password
    ){

        return backstageService.insertUser(name, password)? "success" : "fail";
    }
}

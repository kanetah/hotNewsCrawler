package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
            @RequestParam String id,
            @RequestParam String name
    ){
            return backstageService.updateUserInfo(Integer.valueOf(id), name)? "success" : "fail";
    }

    @RequestMapping("/{name}/deleteUserByName")
    @ResponseBody
    public String deleteUserByName(
            @PathVariable String name
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

    @RequestMapping("/searchUpdatedUser")
    @ResponseBody
    public UserDTO searchUpdatedUser(
            @RequestParam String id
    ){
            return backstageService.searchUpdatedUser(Integer.valueOf(id));
    }


    @RequestMapping("/pagination")
    @ResponseBody
    public List<UserDTO> pagination(
           @RequestParam int pageCode
    ){
                return backstageService.pagination(pageCode);
    }

    @RequestMapping("/pageCount")
    @ResponseBody
    public int pageCount(){
                return backstageService.pageCount();
    }
}

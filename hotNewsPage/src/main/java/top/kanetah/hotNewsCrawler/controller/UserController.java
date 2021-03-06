package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.kanetah.hotNewsCrawler.service.UserService;

import javax.annotation.Resource;

/**
 * created by kane on 2017/11/6.
 */
@RequestMapping("/user")
@Controller("userController")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/leaveComment", method = RequestMethod.POST)
    @ResponseBody
    public String leaveComment(
            @RequestParam String name,
            @RequestParam int newsId,
            @RequestParam String content
    ) {
        return userService.leaveComment(name, newsId, content) ?
                "success" : "fail";
    }

    @RequestMapping("/dropComment")
    @ResponseBody
    public String dropComment(
            @RequestParam String name,
            @RequestParam int newsId
    ) {
        return userService.dropComment(name, newsId) ?
                "success" : "fail";
    }

    @RequestMapping("/changePassword")
    @ResponseBody
    public String changePassword(
            @RequestParam String name,
            @RequestParam String newPassword
    ) {
        return userService.changePassword(name, newPassword) ?
                "success" : "fail";
    }
}

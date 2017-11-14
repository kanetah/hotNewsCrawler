package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kanetah.hotNewsCrawler.model.Comment;
import top.kanetah.hotNewsCrawler.service.UserService;

import javax.annotation.Resource;
import java.sql.Date;

/**
 * created by kane on 2017/11/6.
 */
@RequestMapping("/user")
@Controller("userController")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/leaveComment")
    @ResponseBody
    public String leaveComment(
            @RequestParam int userId,
            @RequestParam int newsId,
            @RequestParam String content
    ) {
        return userService.leaveComment(
                new Comment(userId, newsId, content, new Date(new java.util.Date().getTime()))) ?
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

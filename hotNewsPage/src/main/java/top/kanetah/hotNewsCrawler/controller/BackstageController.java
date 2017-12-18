package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.kanetah.hotNewsCrawler.dto.CommentDTO;
import top.kanetah.hotNewsCrawler.dto.NewsIndexDTO;
import top.kanetah.hotNewsCrawler.dto.UserDTO;
import top.kanetah.hotNewsCrawler.service.BackstageService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@Controller("backstageController")
public class BackstageController {

    @Resource
    private BackstageService backstageService;

    @RequestMapping("/back")
    public String backstagePage() {
        return "Backstage";
    }

    @RequestMapping("/getAllUsers")
    @ResponseBody
    public List<UserDTO> getAllUsers() {
        return backstageService.getAllUsers();
    }

    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public String updateUserInfo(
            @RequestParam int id,
            @RequestParam String name
    ) {
        return backstageService.updateUserInfo(id, name) ? "success" : "fail";
    }

    @RequestMapping("/deleteUserById")
    @ResponseBody
    public String deleteUserById(
            @RequestParam String id
    ) {
        return backstageService.deleteUserById(Integer.valueOf(id)) ? "success" : "fail";
    }

    @RequestMapping("/deleteAllUsers")
    @ResponseBody
    public String deleteAllUsers() {
        return backstageService.deleteAllUsers() ? "success" : "fail";
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(
            @RequestParam String name,
            @RequestParam String password
    ) {

        return backstageService.insertUser(name, password) ? "success" : "fail";
    }

    @RequestMapping("/userPagination")
    @ResponseBody
    public List<UserDTO> userPagination(
            @RequestParam int pageCode, HttpServletRequest request
    ) {
        String addr = request.getLocalAddr();
        return backstageService.userPagination(pageCode, addr);
    }

    @RequestMapping("/userPageCount")
    @ResponseBody
    public int userPageCount() {
        return backstageService.userPageCount();
    }


    @RequestMapping("/newsPagination")
    @ResponseBody
    public List<NewsIndexDTO> newsPagination(
            @RequestParam int pageCode
//            HttpServletRequest request
    ) {
//        String addr = request.getLocalAddr();
        return backstageService.newsPagination(pageCode,"2");
    }

    @RequestMapping("/newsPageCount")
    @ResponseBody
    public int newsPageCount() {
        return backstageService.newsPageCount();
    }

    @RequestMapping("/getAllNews")
    @ResponseBody
    public List<NewsIndexDTO> getAllNews(){
        return backstageService.getAllNews();
    }

    @RequestMapping("/deleteNewsById")
    @ResponseBody
    public boolean deleteNewsById(
            @RequestParam int id
    ){
        return  backstageService.deleteNewsById(id);
    }

    @RequestMapping("/findAllComments")
    @ResponseBody
    public List<CommentDTO> findAllComments(){
                return backstageService.findAllComments();
    }

    @RequestMapping("/commentPageCount")
    @ResponseBody
    public int commentPageCount(){
        return backstageService.commentPageCount();
    }

    @RequestMapping("/commentPagination")
    @ResponseBody
    public List<CommentDTO> commentPagination(
            @RequestParam int pageCode
    ){
        return backstageService.commentPagination(pageCode,"3");
    }

    @RequestMapping("/deleteComments")
    @ResponseBody
    public boolean deleteCommentByUserAndNewsId(
            @RequestParam int id
    ){
                return backstageService.deleteCommentById(id);
    }

    @RequestMapping("/findUserById")
    @ResponseBody
    public UserDTO findUserById(
            @RequestParam int id
    ){
        return backstageService.findUserById(id);
    }

    @RequestMapping("/findUserByName")
    @ResponseBody
    public UserDTO findUserByName(
            @RequestParam String name
    ){
        return backstageService.findUserByName(name);
    }

    @RequestMapping("/deleteCommentByUserId")
    @ResponseBody
    public boolean deleteCommentByUserId(
            @RequestParam int userId
    ){
        return backstageService.deleteCommentByUserId(userId);
    }

    @RequestMapping("/deleteCommentsByNewsId")
    @ResponseBody
    public boolean deleteCommentByNewsId(
            @RequestParam int newsId
    ){
        return backstageService.deleteCommentByNewsId(newsId);
    }

    @RequestMapping("/findCommentById")
    @ResponseBody
    public CommentDTO  findCommentById(
           @RequestParam int id
    ){
        return backstageService.findCommentById(id);
    }

    @RequestMapping("/findCommentsByNewsId")
    @ResponseBody
    public List<CommentDTO>  findCommentByNewsId(
            @RequestParam int newsId
    ){
        return backstageService.findCommentByNewsId(newsId);
    }

    @RequestMapping("/findCommentsByUserId")
    @ResponseBody
    public List<CommentDTO>  findCommentByUserId(
            @RequestParam int userId
    ){
        return backstageService.findCommentByUserId(userId);
    }

    @RequestMapping("/findNewsById")
    @ResponseBody
    public NewsIndexDTO findNewsById(
            @RequestParam int id
    ){
        return backstageService.findNewsById(id);
    }

    @RequestMapping("/findNewsByTitle")
    @ResponseBody
    public List<NewsIndexDTO> findNewsByTitle(
            @RequestParam String title
    ){
        return backstageService.findNewsByTitle_Like(title);
    }

    @RequestMapping("/findNewsByDate")
    @ResponseBody
    public List<NewsIndexDTO> findNewsByDate(
            @RequestParam Date fromDate,
            @RequestParam Date toDate
    ){
        return backstageService.findNewsByDate(fromDate, toDate);
    }
}

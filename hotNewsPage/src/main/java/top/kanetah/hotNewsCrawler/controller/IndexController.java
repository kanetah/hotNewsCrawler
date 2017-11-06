package top.kanetah.hotNewsCrawler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kanetah.hotNewsCrawler.dao.CommentDAO;
import top.kanetah.hotNewsCrawler.dao.NewsDAO;
import top.kanetah.hotNewsCrawler.dao.UserDAO;
import top.kanetah.hotNewsCrawler.model.Comment;
import top.kanetah.hotNewsCrawler.model.News;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * created by kane on 2017/10/28.
 */
@Controller("indexController")
@RequestMapping("/")
public class IndexController {

//    @Resource
//    private NewsDAO newsDAO;
//    @Resource
//    private CommentDAO commentDAO;
//    @Resource
//    private UserDAO userDAO;

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

//    @ResponseBody
//    @RequestMapping("/out")
//    public List<News> outPage() {
//
//        List<News> list = newsDAO.findNewsByType("网易体育", 0);
//
//        return list;
//    }
}

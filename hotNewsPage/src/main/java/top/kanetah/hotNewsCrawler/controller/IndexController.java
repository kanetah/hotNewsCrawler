package top.kanetah.hotNewsCrawler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kanetah.hotNewsCrawler.dao.NewsDAO;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Resource
    private NewsDAO newsDAO;

    @RequestMapping("/")
    public String indexPage() {
        System.out.println("poi");
        System.out.println(newsDAO.findNewsById(2169).getContent());
        System.out.println("poi");

        return "index";
    }

    @RequestMapping(value = "/out")
    @ResponseBody
    public String outPage() {
        logger.info("found: " + newsDAO.findNewsById(2169).getContent());
        return newsDAO.findNewsById(2169).getContent();
    }
}

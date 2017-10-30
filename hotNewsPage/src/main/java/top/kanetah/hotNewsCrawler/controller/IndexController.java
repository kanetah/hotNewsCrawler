package top.kanetah.hotNewsCrawler.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kanetah.hotNewsCrawler.dao.NewsDAO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * created by kane on 2017/10/28.
 */
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

    @ResponseBody
    @RequestMapping("/out")
    public List<String> outPage() {
        logger.info("found: " + newsDAO.findNewsById(2169).getContent());

        List<String> list = new ArrayList<String>();
        list.add("abc");
        list.add("def");
        return list;
    }
}

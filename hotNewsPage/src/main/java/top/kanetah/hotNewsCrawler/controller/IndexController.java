package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kanetah.hotNewsCrawler.dao.CrawlerInfoDAO;
import top.kanetah.hotNewsCrawler.model.CrawlerInfo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * created by kane on 2017/10/28.
 */
@Controller("indexController")
public class IndexController {

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

    @ResponseBody
    @RequestMapping("/out")
    public List<String> outPage() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        return list;
    }
}

package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.kanetah.hotNewsCrawler.dao.CrawlerInfoDAO;

import javax.annotation.Resource;

/**
 * created by kane on 2017/10/28.
 */
@Controller("indexController")
public class IndexController {

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/news/{id}")
    public String newsPage(
            @PathVariable String id,
            Model model
    ) {
        model.addAttribute("id", id);
        return "news";
    }

//    @ResponseBody
//    @RequestMapping("/out")
//    public List<CrawlerInfo> outPage() {
//        return crawlerInfoDAO.findAllCrawlerInfo();
//    }
}

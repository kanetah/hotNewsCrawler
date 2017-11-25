package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import top.kanetah.hotNewsCrawler.model.News;
import top.kanetah.hotNewsCrawler.service.NewsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by kane on 2017/10/28.
 */
@Controller("indexController")
@SessionAttributes("name")
public class IndexController {

    @Resource
    private NewsService newsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public List<News> getAllNews() {
        return newsService.getAllNews();
    }

    @ResponseBody
    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public List<Integer> getNews() {
        return newsService.getTopNewsId();
    }
}

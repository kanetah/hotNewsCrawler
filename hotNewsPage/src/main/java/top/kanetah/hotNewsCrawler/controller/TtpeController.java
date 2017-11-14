package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kanetah.hotNewsCrawler.model.News;
import top.kanetah.hotNewsCrawler.service.NewsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by kane on 2017/11/6.
 */
@RequestMapping("/news")
@Controller("newsController")
public class TtpeController {

    @Resource
    private NewsService newsService;

    @RequestMapping("/types")
    @ResponseBody
    public List<String> getTypes() {
        return newsService.getTypes();
    }

    @RequestMapping("/topTypeNews")
    @ResponseBody
    public List<News> getTopTypeNews(
            @RequestParam String type,
            @RequestParam int limit
    ) {
        return newsService.getTopNewsByType(type, limit);
    }
}

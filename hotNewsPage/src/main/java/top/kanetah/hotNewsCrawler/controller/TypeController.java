package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kanetah.hotNewsCrawler.service.NewsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by kane on 2017/11/6.
 */
@RequestMapping("/news")
@Controller("newsController")
public class TypeController {

    @Resource
    private NewsService newsService;

    @RequestMapping("/types")
    @ResponseBody
    public List<String> getTypes() {
        return newsService.getTypes();
    }

    @RequestMapping("/topTypeNews")
    @ResponseBody
    public List<Integer> getTopTypeNews(
            @RequestParam String type
    ) {
        return newsService.getTopNewsIdByType(type);
    }
}

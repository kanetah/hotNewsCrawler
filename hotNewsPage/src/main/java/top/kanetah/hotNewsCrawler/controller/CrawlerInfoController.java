package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kanetah.hotNewsCrawler.model.CrawlerInfo;
import top.kanetah.hotNewsCrawler.service.CrawlerInfoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by kane on 2017/11/6.
 */
@RequestMapping("/crawler")
@Controller("crawlerInfoController")
public class CrawlerInfoController {

    @Resource
    private CrawlerInfoService crawlerInfoService;

    @RequestMapping("/addCrawlerInfo")
    @ResponseBody
    public String addCrawlerInfo(
            @RequestParam String state,
            @RequestParam String message
    ) {
        return crawlerInfoService.addCrawlerInfo(
                new CrawlerInfo(state, message)
        ) ? "success" : "fail";
    }

    @RequestMapping("/dropCrawlerInfo")
    @ResponseBody
    public String dropCrawlerInfo(
            @RequestParam int id
    ) {
        return crawlerInfoService.dropCrawlerInfo(id) ?
                "success" : "fail";
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<CrawlerInfo> getAll(){
        return crawlerInfoService.getAll();
    }
}

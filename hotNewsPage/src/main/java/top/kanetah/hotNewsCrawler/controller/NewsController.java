package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kanetah.hotNewsCrawler.dto.CommentDTO;
import top.kanetah.hotNewsCrawler.dto.NewsIndexDTO;
import top.kanetah.hotNewsCrawler.model.News;
import top.kanetah.hotNewsCrawler.service.NewsService;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/news")
@Controller("contentController")
public class NewsController {

    @Resource
    private NewsService newsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String newsPage(
            @PathVariable String id, Model model
    ) {
        model.addAttribute("id", id);
        return "news";
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public NewsIndexDTO getNewsIndexDTO(
            @PathVariable int id
    ) {
        News news = newsService.getNewsById(id);
        return new NewsIndexDTO(
                news.getId(), news.getSrc(), news.getTitle(), news.getDate(),
                news.getType(), news.getRank(), news.getContent()
        );
    }

    @ResponseBody
    @RequestMapping("/{id}/content")
    public News getContent(
            @PathVariable int id
    ) {
        return newsService.getNewsById(id);
    }

    @ResponseBody
    @RequestMapping("/{id}/comments")
    public List<CommentDTO> getComment(
            @PathVariable int id
    ) {
        return newsService.getCommentDTOByNewsId(id);
    }

    @ResponseBody
    @RequestMapping("/find/{title}")
    public List<News> getRelatedNews(
            @PathVariable String title
    ) {
        return newsService.getRelatedNews(title);
    }
}

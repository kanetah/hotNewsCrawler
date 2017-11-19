package top.kanetah.hotNewsCrawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.kanetah.hotNewsCrawler.DTO.CommentDTO;
import top.kanetah.hotNewsCrawler.model.News;
import top.kanetah.hotNewsCrawler.service.NewsService;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/news")
@Controller("contentController")
public class NewsController {

    @Resource
    private NewsService newsService;

    @RequestMapping("/{id}")
    public String newsPage(
            @PathVariable String id, Model model
    ) {
        model.addAttribute("id", id);
        return "news";
    }

    @ResponseBody
    @RequestMapping("/{id}/content")
    public News getContent(
            @PathVariable String id
    ) {
        return newsService.getNewsById(Integer.valueOf(id));
    }

    @ResponseBody
    @RequestMapping("/{id}/comments")
    public List<CommentDTO> getComment(
            @PathVariable String id
    ) {
        return newsService.getCommentDTOByNewsId(Integer.valueOf(id));
    }
}

package top.kanetah.hotNewsCrawler.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.kanetah.hotNewsCrawler.dto.CommentDTO;
import top.kanetah.hotNewsCrawler.dao.CommentDAO;
import top.kanetah.hotNewsCrawler.dao.NewsDAO;
import top.kanetah.hotNewsCrawler.dao.UserDAO;
import top.kanetah.hotNewsCrawler.model.Comment;
import top.kanetah.hotNewsCrawler.model.News;
import top.kanetah.hotNewsCrawler.service.NewsService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * created by kane on 2017/10/28.
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {

    private Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Resource
    private NewsDAO newsDAO;
    @Resource
    private CommentDAO commentDAO;
    @Resource
    private UserDAO userDAO;

    public List<News> getAllNews() {
        return newsDAO.findAllNews();
    }

    public News getNewsById(int id) {
        return newsDAO.findNewsById(id);
    }

    public List<CommentDTO> getCommentDTOByNewsId(int id) {
        List<CommentDTO> commentDTOs = new ArrayList<CommentDTO>();
        List<Comment> comments = commentDAO.findCommentByNews_Id(id);
        News news = newsDAO.findNewsById(id);
        for (Comment comment : comments) {
            commentDTOs.add(new CommentDTO(
                    comment.getId(),
                    userDAO.findUserById(comment.getUserId()).getName(),
                    news.getTitle(),
                    comment.getContent(),
                    comment.getTime().toString()
            ));
        }
        return commentDTOs;
    }

    public List<String> getTypes() {
        return newsDAO.findAllTypes();
    }

    public List<Integer> getTopNewsId() {
        return newsDAO.findNewsIdOrderByRank();
    }

    public List<Integer> getTopNewsIdByType(String type) {
        return newsDAO.findNewsIdByTypeOrderByRank(type);
    }
}

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
import java.util.Comparator;
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

    public List<Integer> searchNews(String title) {
        List<Integer> list = new ArrayList<Integer>();
        for (News news : newsDAO.findNewsByTitle_Like("%" + title + "%"))
            list.add(news.getId());
        return list;
    }

    public List<News> getRelatedNews(String title) {
        List<News> result = new ArrayList<>();
        newsDAO.findAllTitle().forEach((t) -> {
            if (minDistance(t, title) < 20)
                result.addAll(newsDAO.findNewsByTitle_Like(t));
        });
        result.sort(Comparator.comparingInt(o -> minDistance(o.getTitle(), title)));
        return result.subList(1, result.size() > 20 ? 20 : result.size());
    }

    /*
     * Edit Distance in Java
     */
    private int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);

                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;
                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }

        return dp[len1][len2];
    }
}

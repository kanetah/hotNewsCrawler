package top.kanetah.hotNewsCrawler.service;

import top.kanetah.hotNewsCrawler.dto.CommentDTO;
import top.kanetah.hotNewsCrawler.model.News;

import java.util.List;

/**
 * created by kane on 2017/10/28.
 */
public interface NewsService {

    List<News> getAllNews();

    News getNewsById(int id);

    List<CommentDTO> getCommentDTOByNewsId(int id);

    List<String> getTypes();

    List<Integer> getTopNewsId();

    List<Integer> getTopNewsIdByType(String type);
}

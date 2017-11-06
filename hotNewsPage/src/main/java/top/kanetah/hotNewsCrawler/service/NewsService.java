package top.kanetah.hotNewsCrawler.service;

import top.kanetah.hotNewsCrawler.model.News;

import java.util.List;

/**
 * created by kane on 2017/10/28.
 */
public interface NewsService {

    News getById(int id);

    List<String> getTypes();

    List<News> getTopNewsByType(String type, int limit);
}

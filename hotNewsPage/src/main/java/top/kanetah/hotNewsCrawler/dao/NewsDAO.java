package top.kanetah.hotNewsCrawler.dao;

import org.springframework.stereotype.Repository;
import top.kanetah.hotNewsCrawler.model.News;

/**
 * created by kane on 2017/10/28.
 */
@Repository("newsDao")
public interface NewsDAO {

    News findNewsById(int id);
}

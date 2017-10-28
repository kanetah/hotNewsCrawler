package top.kanetah.hotNewsCrawler.dao;

import org.springframework.stereotype.Repository;
import top.kanetah.hotNewsCrawler.model.News;

@Repository("newsDao")
public interface NewsDAO {

    News findNewsById(int id);
}

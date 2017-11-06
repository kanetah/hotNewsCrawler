package top.kanetah.hotNewsCrawler.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.kanetah.hotNewsCrawler.dao.NewsDAO;
import top.kanetah.hotNewsCrawler.model.News;
import top.kanetah.hotNewsCrawler.service.NewsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by kane on 2017/10/28.
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService {

    private Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);

    @Resource
    private NewsDAO newsDAO;

    public News getById(int id) {
        return newsDAO.findNewsById(id);
    }

    public List<String> getTypes() {
        return null;
    }

    public List<News> getTopNewsByType(String type, int limit) {
        return null;
    }
}

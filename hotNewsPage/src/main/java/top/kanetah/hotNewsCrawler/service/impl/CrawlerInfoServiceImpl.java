package top.kanetah.hotNewsCrawler.service.impl;

import org.springframework.stereotype.Service;
import top.kanetah.hotNewsCrawler.model.CrawlerInfo;
import top.kanetah.hotNewsCrawler.service.CrawlerInfoService;

import java.util.List;

/**
 * created by kane on 2017/11/6.
 */
@Service("crawlerInfoService")
public class CrawlerInfoServiceImpl implements CrawlerInfoService {
    public boolean addCrawlerInfo(CrawlerInfo crawlerInfo) {
        return false;
    }

    public boolean dropCrawlerInfo(int id) {
        return false;
    }

    public List<CrawlerInfo> getAll() {
        return null;
    }
}

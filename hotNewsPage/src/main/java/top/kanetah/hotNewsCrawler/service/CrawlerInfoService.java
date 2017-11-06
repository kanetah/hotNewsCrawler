package top.kanetah.hotNewsCrawler.service;

import top.kanetah.hotNewsCrawler.model.CrawlerInfo;

import java.util.List;

/**
 * created by kane on 2017/11/6.
 */
public interface CrawlerInfoService {

    boolean addCrawlerInfo(CrawlerInfo crawlerInfo);

    boolean dropCrawlerInfo(int id);

    List<CrawlerInfo> getAll();
}

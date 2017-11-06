package top.kanetah.hotNewsCrawler.dao;

import org.springframework.stereotype.Repository;
import top.kanetah.hotNewsCrawler.model.CrawlerInfo;

import java.util.List;

/**
 * created by kane on 2017/11/6.
 */
@Repository("crawlerInfoDAO")
public interface CrawlerInfoDAO {

    /**
     * 插入一条爬虫信息
     *
     * @param crawlerInfo 爬虫信息实体
     * @return 被影响的总行数
     */
    int inertCrawlerInfo(CrawlerInfo crawlerInfo);

    /**
     * 查找所有爬虫信息
     *
     * @return 所有爬虫信息实体
     */
    List<CrawlerInfo> findAllCrawlerInfo();
}

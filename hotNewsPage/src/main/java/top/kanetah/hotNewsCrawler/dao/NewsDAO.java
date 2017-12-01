package top.kanetah.hotNewsCrawler.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.kanetah.hotNewsCrawler.model.News;

import java.sql.Date;
import java.util.List;

/**
 * created by kane on 2017/10/28.
 */
@Repository("newsDao")
public interface NewsDAO {

    /**
     * 删除所有新闻
     *
     * @return 被影响的总行数
     */
    int deleteAllNews();

    /**
     * 查找所有新闻
     *
     * @return 所有的新闻
     */
    List<News> findAllNews();

    /**
     * 通过id查找新闻
     *
     * @param id 新闻id
     * @return 新闻实体
     */
    News findNewsById(int id);

    /**
     * 查找两个日期之间的所有新闻
     *
     * @param after  较早的日期
     * @param before 较迟的日期
     * @return 符合条件的所有新闻实体
     */
    List<News> findNewsBetweenDate(@Param("after") Date after, @Param("before") Date before);

    /**
     * 通过新闻类型查找新闻
     * 将通过date对结果排序，返回前$count条新闻
     *
     * @param type  新闻的类型
     * @param count 需要查找的数量
     * @return 符合条件的所有新闻实体
     */
    List<News> findNewsByType(@Param("type") String type, @Param("count") int count);

    /**
     * 通过新闻标题查找新闻
     * 支持模糊查询
     *
     * @param title 新闻标题
     * @return 符合条件的所有新闻实体
     */
    List<News> findNewsByTitle_Like(String title);

    /**
     * 查找新闻Id并以热度排序
     *
     * @return 所有新闻的id
     */
    List<Integer> findNewsIdOrderByRank();

    /**
     * 通过新闻类型查找新闻Id并热度排序
     *
     * @param type 新闻类型
     * @return 该类型的所有新闻id
     */
    List<Integer> findNewsIdByTypeOrderByRank(String type);

    /**
     * 查找所有存在的新闻类型
     *
     * @return 所有新闻类型
     */
    List<String> findAllTypes();

    /**
     * 通过id删除指定新闻
     * @param id
     * @return 被影响的行数
     */
    int deleteNewsById(int id);
}

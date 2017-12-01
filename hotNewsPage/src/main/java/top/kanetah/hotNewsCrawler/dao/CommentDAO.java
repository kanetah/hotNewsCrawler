package top.kanetah.hotNewsCrawler.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.kanetah.hotNewsCrawler.model.Comment;

import java.util.List;

/**
 * created by kane on 2017/11/6.
 */
@Repository("commentDao")
public interface CommentDAO {

    /**
     * 增加一条留言
     *
     * @param comment 留言实体
     * @return 被影响的总行数
     */
    int insertComment(Comment comment);

    /**
     * 删除所有留言
     *
     * @return 被影响的总行数
     */
    int deleteAllComment();

    /**
     * 删除一条新闻下的所有留言
     *
     * @param newsId 新闻id
     * @return 被影响的总行数
     */
    int deleteCommentByNews_Id(@Param("newsId") int newsId);

    /**
     * 删除一位用户的所有留言
     *
     * @param userId 用户id
     * @return 被影响的总行数
     */
    int deleteCommentByUser_Id(@Param("userId") int userId);

    /**
     * 删除一个用户对一条新闻的所有留言
     *
     * @param newsId 新闻id
     * @param userId 用户id
     * @return 被影响的总行数
     */
    int deleteCommentByNews_IdAndUser_Id(@Param("newsId") int newsId, @Param("userId") int userId);

    /**
     * 修改一条留言
     *
     * @param comment 留言实体
     * @return 被影响的总行数
     */
    int updateComment(Comment comment);

    /**
     * 通过id查找留言
     *
     * @param id 留言id
     * @return 找到的留言
     */
    Comment findCommentById(int id);

    /**
     * 查找一条新闻下的所有留言
     *
     * @param newsId 新闻id
     * @return 找到的所有留言
     */
    List<Comment> findCommentByNews_Id(int newsId);

    /**
     * 查找所有评论
     * @return 查找到的所有评论
     */
    List<Comment> findAllComments();
}

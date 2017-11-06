package top.kanetah.hotNewsCrawler.service;

import top.kanetah.hotNewsCrawler.model.Comment;

/**
 * created by kane on 2017/11/6.
 */
public interface UserService {

    boolean leaveComment(Comment comment);

    boolean dropComment(String name, int newsId);

    boolean changePassword(String name, String newPassword);
}

package top.kanetah.hotNewsCrawler.service.impl;

import org.springframework.stereotype.Service;
import top.kanetah.hotNewsCrawler.dao.CommentDAO;
import top.kanetah.hotNewsCrawler.dao.UserDAO;
import top.kanetah.hotNewsCrawler.dto.UserDTO;
import top.kanetah.hotNewsCrawler.model.Comment;
import top.kanetah.hotNewsCrawler.model.User;
import top.kanetah.hotNewsCrawler.service.UserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created by kane on 2017/11/6.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private CommentDAO commentDAO;
    @Resource
    private UserDAO userDAO;

    public boolean leaveComment(Comment comment) {
        return commentDAO.insertComment(comment) > 0;
    }

    public boolean leaveComment(String username, int newsId, String content) {
        int userId = userDAO.findUserByName(username).getId();
        return leaveComment(
                new Comment(userId, newsId, content, new java.sql.Date(new java.util.Date().getTime())));
    }

    public boolean dropComment(String name, int newsId) {
        return false;
    }

    public boolean changePassword(String name, String newPassword) {
        return false;
    }
}

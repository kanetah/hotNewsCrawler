package top.kanetah.hotNewsCrawler.service.impl;

import org.springframework.stereotype.Service;
import top.kanetah.hotNewsCrawler.model.Comment;
import top.kanetah.hotNewsCrawler.service.UserService;

/**
 * created by kane on 2017/11/6.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    public boolean leaveComment(Comment comment) {
        return false;
    }

    public boolean dropComment(String name, int newsId) {
        return false;
    }

    public boolean changePassword(String name, String newPassword) {
        return false;
    }
}

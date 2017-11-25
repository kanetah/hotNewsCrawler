package top.kanetah.hotNewsCrawler.service;

import top.kanetah.hotNewsCrawler.dto.UserDTO;
import top.kanetah.hotNewsCrawler.model.Comment;

import java.util.Date;
import java.util.List;

/**
 * created by kane on 2017/11/6.
 */
public interface UserService {

    boolean leaveComment(Comment comment);

    boolean leaveComment(String username, int newsId, String content);

    boolean dropComment(String name, int newsId);

    boolean changePassword(String name, String newPassword);

    List<UserDTO> getAllUsers();
}

package top.kanetah.hotNewsCrawler.service;

import top.kanetah.hotNewsCrawler.dao.NewsDAO;
import top.kanetah.hotNewsCrawler.dto.CommentDTO;
import top.kanetah.hotNewsCrawler.dto.NewsIndexDTO;
import top.kanetah.hotNewsCrawler.dto.UserDTO;
import top.kanetah.hotNewsCrawler.model.Comment;

import java.util.List;

public interface BackstageService {

    /*
     * user
     */
    List<UserDTO> getAllUsers();

    boolean updateUserInfo(int id, String name);

    boolean deleteUserById(int id);

    boolean deleteAllUsers();

    boolean insertUser(String name, String password);

    List<UserDTO> userPagination(int pageCode, String addr);

    int userPageCount();

    UserDTO findUserById(int id);

    UserDTO findUserByName(String name);

    /*
     * news
     */
    List<NewsIndexDTO> newsPagination(int pageCode, String addr);

    int newsPageCount();

    List<NewsIndexDTO> getAllNews();

    boolean deleteNewsById(int id);

    /*
     * comment
     */
    List<CommentDTO> findAllComments();

    int commentPageCount();

    List<CommentDTO> commentPagination(int pageCode, String addr);

    boolean deleteCommentByUserAndNewsId(int userId, int newsId);

    boolean deleteCommentByUserId(int userId);

    boolean deleteCommentByNewsId(int newsId);

    CommentDTO  findCommentById(int id);

    List<CommentDTO> findCommentByNewsId(int newId);

    List<CommentDTO> findCommentByUserId(int userId);

}

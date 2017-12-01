package top.kanetah.hotNewsCrawler.service;

import top.kanetah.hotNewsCrawler.dao.NewsDAO;
import top.kanetah.hotNewsCrawler.dto.NewsIndexDTO;
import top.kanetah.hotNewsCrawler.dto.UserDTO;

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

}

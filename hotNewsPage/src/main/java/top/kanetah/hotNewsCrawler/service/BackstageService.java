package top.kanetah.hotNewsCrawler.service;

import top.kanetah.hotNewsCrawler.dto.UserDTO;

import java.util.List;

public interface BackstageService {

    List<UserDTO> getAllUsers();

    boolean updateUserInfo(int id, String name);

    boolean deleteUserById(int id);

    boolean deleteAllUsers();

    boolean insertUser(String name, String password);

    List<UserDTO> pagination(int pageCode, String addr);

    int pageCount();

}

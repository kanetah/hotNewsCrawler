package top.kanetah.hotNewsCrawler.service;

import top.kanetah.hotNewsCrawler.dto.UserDTO;

import java.util.List;

public interface BackstageService {

    List<UserDTO> getAllUsers();

    boolean updateUserInfo(int id, String name);

    boolean deleteUserByName(String name);

    boolean deleteAllUsers();

    boolean insertUser(String name, String password);
}

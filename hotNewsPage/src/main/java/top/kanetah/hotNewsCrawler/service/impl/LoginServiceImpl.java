package top.kanetah.hotNewsCrawler.service.impl;

import org.springframework.stereotype.Service;
import top.kanetah.hotNewsCrawler.dao.UserDAO;
import top.kanetah.hotNewsCrawler.model.User;
import top.kanetah.hotNewsCrawler.service.LoginService;

import javax.annotation.Resource;

/**
 * created by kane on 2017/11/6.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserDAO userDAO;

    public boolean login(String name, String password) {
        return userDAO.findUserByNameAndPassword(name, password) != null;
    }

    public boolean logout(String name) {
        return true;
    }

    public boolean register(String name, String password) {
        return userDAO.insertUser(new User(name, password)) > 0;
    }
}

package top.kanetah.hotNewsCrawler.service.impl;

import org.springframework.stereotype.Service;
import top.kanetah.hotNewsCrawler.dao.UserDAO;
import top.kanetah.hotNewsCrawler.dto.UserDTO;
import top.kanetah.hotNewsCrawler.model.User;
import top.kanetah.hotNewsCrawler.service.BackstageService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("backstageService")
public class BackstageServiceImpl implements BackstageService {

    @Resource
    private UserDAO userDAO;

    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        List<User> users = userDAO.findAllUser();//userDTOs类型与userDao.findAllUser所返回类型不相同
        for (User user : users){
            userDTOs.add(new UserDTO(
                    user.getId(),
                    user.getName()
            ));
        }
        return userDTOs;
    }

    public boolean updateUserInfo(int id, String name){
        User auser = new User(id, name);
        int result = userDAO.updateUser(auser);
        if(result != 0){
            return true;
        }
        return false;
    }

    public boolean deleteUserByName(String name) {
        int result = userDAO.deleteUserByName(name);
        if (result != 0){
            return true;
        }
        return false;
    }

    public boolean deleteAllUsers(){
        int result = userDAO.deleteAllUser();
        if (result != 0){
            return true;
        }
        return false;
    }

    public boolean insertUser(String name, String password){
        User auser = new User(name, password);
        int result = userDAO.insertUser(auser);
        if (result != 0){
            return true;
        }
        return false;
    }

}

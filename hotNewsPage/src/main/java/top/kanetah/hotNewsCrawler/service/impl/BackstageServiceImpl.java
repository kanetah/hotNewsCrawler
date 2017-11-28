package top.kanetah.hotNewsCrawler.service.impl;

import org.springframework.stereotype.Service;
import top.kanetah.hotNewsCrawler.dao.UserDAO;
import top.kanetah.hotNewsCrawler.dto.UserDTO;
import top.kanetah.hotNewsCrawler.model.User;
import top.kanetah.hotNewsCrawler.service.BackstageService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("backstageService")
public class BackstageServiceImpl implements BackstageService {

    @Resource
    private UserDAO userDAO;
    private int pageSize = 20;
    private HashMap<String, List<UserDTO>> userMap = new HashMap<String, List<UserDTO>>();

    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();
        List<User> users = userDAO.findAllUser();//userDTOs类型与userDao.findAllUser所返回类型不相同
        for (User user : users) {
            userDTOs.add(new UserDTO(
                    user.getId(),
                    user.getName()
            ));
        }
        return userDTOs;
    }

    public boolean updateUserInfo(int id, String name) {
        User user = userDAO.findUserById(id);
        user.setName(name);
        return userDAO.updateUser(user) > 0;
    }

    public boolean deleteUserById(int id) {
        int result = userDAO.deleteUserById(id);
        return result != 0;
    }

    public boolean deleteAllUsers() {
        int result = userDAO.deleteAllUser();
        return result != 0;
    }

    public boolean insertUser(String name, String password) {
        User auser = new User(name, password);
        int result = userDAO.insertUser(auser);
        if (result != 0) {
            return true;
        }
        return false;
    }

    public int pageCount() {
        List<UserDTO> userDTOS = getAllUsers();
        int rest = userDTOS.size() % pageSize;
        int pageCount = 0;
        int count = userDTOS.size() / pageSize;
        if (rest == 0){
            pageCount = count;
        }
        else{
            pageCount = count + 1;
        }

        return pageCount;
    }

    public List<UserDTO> pagination(int pageCode, String addr) {

        if (pageCode == 1 || pageCode == pageCount())
            userMap.put(addr, getAllUsers());
        List<UserDTO> userDTOS = userMap.get(addr);
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        int from = (pageCode - 1) * pageSize;
        for (int i = from; i < from + pageSize; ++i)
            try {
                userDTOList.add(userDTOS.get(i));
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        return userDTOList;
    }

}

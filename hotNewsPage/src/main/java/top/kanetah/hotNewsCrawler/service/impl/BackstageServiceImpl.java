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
    private int pageSize = 10;

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
        User user = userDAO.findUserById(id);
        user.setName(name);
        return userDAO.updateUser(user) > 0;
    }

    public boolean deleteUserByName(String name) {
        int result = userDAO.deleteUserByName(name);
        return result != 0;
    }

    public boolean deleteAllUsers(){
        int result = userDAO.deleteAllUser();
        return result != 0;
    }

    public boolean insertUser(String name, String password){
        User auser = new User(name, password);
        int result = userDAO.insertUser(auser);
        if (result != 0){
            return true;
        }
        return false;
    }

    public UserDTO searchUpdatedUser(int id) {
       User user = userDAO.findUserById(id);//userDTOs类型与userDao.findAllUser所返回类型不相同
        UserDTO userDTO = new UserDTO(user.getId(), user.getName());
        return userDTO;
    }

    public List<UserDTO> pagination(int pageCode) {
        List<UserDTO> userDTOS = getAllUsers();
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        int count = 0;
//        if(pageCode == 1){
            for(UserDTO userDTO:userDTOS){
                if (pageCode == 1){
                    if (count < 10){
                        userDTOList.add(count,new UserDTO(userDTO.getId(), userDTO.getUsername()));
                        count++;
                    }else{
                        break;
                    }
                }else if(pageCode > 1){
                    int increment = (pageCode-1)*pageSize;
                    if (count < 10){
                        userDTOList.add(count+increment,new UserDTO(userDTO.getId(), userDTO.getUsername()));
                        count++;
                    }else{
                        break;
                    }
                }
            }
//        }
        return userDTOList;
    }

    public int pageCount() {
        List<UserDTO> userDTOS = getAllUsers();
        double count = userDTOS.size() / pageSize;
        int pageCount=0;
        if(String.valueOf(count).contains(".")){
            pageCount = (int)count + 1;
        }
        return pageCount;
    }
}

package top.kanetah.hotNewsCrawler.service.impl;

import org.springframework.stereotype.Service;
import top.kanetah.hotNewsCrawler.dao.NewsDAO;
import top.kanetah.hotNewsCrawler.dao.UserDAO;
import top.kanetah.hotNewsCrawler.dto.NewsIndexDTO;
import top.kanetah.hotNewsCrawler.dto.UserDTO;
import top.kanetah.hotNewsCrawler.model.News;
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

    @Resource
    private NewsDAO newsDAO;

    final private int UserPageSize = 20;
    final private int NewsPageSize = 80;
    private HashMap<String, List<UserDTO>> userMap = new HashMap<String, List<UserDTO>>();
    private HashMap<String, List<NewsIndexDTO>> newsMap = new HashMap<String, List<NewsIndexDTO>>();


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
        int result = userDAO.insertUser(new User(name, password));
        return result != 0;
    }

    public int userPageCount() {
        List<UserDTO> userDTOS = getAllUsers();
        int rest = userDTOS.size() % UserPageSize;
        int count = userDTOS.size() / UserPageSize;
        int pageCount;
        if (rest == 0){
            pageCount = count;
        }
        else{
            pageCount = count + 1;
        }

        return pageCount;
    }

    public List<UserDTO> userPagination(int pageCode, String addr) {

        if (pageCode == 1 || pageCode == userPageCount())
            userMap.put(addr, getAllUsers());
        List<UserDTO> userDTOS = userMap.get(addr);
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        int from = (pageCode - 1) * UserPageSize;
        for (int i = from; i < from + UserPageSize; ++i)
            try {
                userDTOList.add(userDTOS.get(i));
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        return userDTOList;
    }

    public List<NewsIndexDTO> getAllNews() {
        List<News> news = newsDAO.findAllNews();
        List<NewsIndexDTO> newsIndexDTOS = new ArrayList<NewsIndexDTO>();
        for (int i = news.size()-1; i >= 0; i--) {
            newsIndexDTOS.add(new NewsIndexDTO(
                    news.get(i).getId(),
                    news.get(i).getSrc(),
                    news.get(i).getTitle(),
                    news.get(i).getDate(),
                    news.get(i).getType(),
                    news.get(i).getRank()

            ));
        }
        return newsIndexDTOS;
    }
    public int newsPageCount() {
        List<NewsIndexDTO> newsIndexDTOS = getAllNews();
        int rest = newsIndexDTOS.size() % NewsPageSize;
        int count = newsIndexDTOS.size() / NewsPageSize;
        int pageCount;
        if (rest == 0){
            pageCount = count;
        }
        else{
            pageCount = count + 1;
        }

        return pageCount;
    }
    public List<NewsIndexDTO> newsPagination(int pageCode, String addr) {

//        if(pageCode == 1 || pageCode == newsPageCount())
            newsMap.put(addr, getAllNews());
        List<NewsIndexDTO> newsIndexDTOS = newsMap.get(addr);
        List<NewsIndexDTO> newsIndexDTOList = new ArrayList<NewsIndexDTO>();
        int from = (pageCode - 1) * NewsPageSize;
        for (int i = from; i < from + NewsPageSize; ++i) {
            try {
                newsIndexDTOList.add(newsIndexDTOS.get(i));
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return newsIndexDTOList;
    }

    public boolean deleteNewsById(int id){
        int result = newsDAO.deleteNewsById(id);
        return result!= 0;
    }
}

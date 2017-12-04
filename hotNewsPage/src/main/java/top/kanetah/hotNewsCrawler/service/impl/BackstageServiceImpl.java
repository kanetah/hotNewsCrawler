package top.kanetah.hotNewsCrawler.service.impl;

import org.springframework.stereotype.Service;
import top.kanetah.hotNewsCrawler.dao.CommentDAO;
import top.kanetah.hotNewsCrawler.dao.NewsDAO;
import top.kanetah.hotNewsCrawler.dao.UserDAO;
import top.kanetah.hotNewsCrawler.dto.CommentDTO;
import top.kanetah.hotNewsCrawler.dto.NewsIndexDTO;
import top.kanetah.hotNewsCrawler.dto.UserDTO;
import top.kanetah.hotNewsCrawler.model.Comment;
import top.kanetah.hotNewsCrawler.model.News;
import top.kanetah.hotNewsCrawler.model.User;
import top.kanetah.hotNewsCrawler.service.BackstageService;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("backstageService")
public class BackstageServiceImpl implements BackstageService {

    @Resource
    private UserDAO userDAO;

    @Resource
    private NewsDAO newsDAO;

    @Resource
    private CommentDAO commentDAO;

    final private int UserPageSize = 20;
    final private int NewsPageSize = 80;
    final private int CommentPageSize = 100;
    private HashMap<String, List<UserDTO>> userMap = new HashMap<String, List<UserDTO>>();
    private HashMap<String, List<NewsIndexDTO>> newsMap = new HashMap<String, List<NewsIndexDTO>>();
    private HashMap<String, List<CommentDTO>> commentMap = new HashMap<String, List<CommentDTO>>();


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

    public UserDTO findUserById(int id) {
        User user = userDAO.findUserById(id);
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getName()
        );
        return userDTO;
    }

    public UserDTO findUserByName(String name) {
        User user = userDAO.findUserByName(name);
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getName()
        );
        return userDTO;
    }

    /*
        news
         */
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

    public NewsIndexDTO findNewsById(int id){
        News news = newsDAO.findNewsById(id);
        NewsIndexDTO newsIndexDTO = new NewsIndexDTO(
                news.getId(),
                news.getSrc(),
                news.getTitle(),
                news.getDate(),
                news.getType(),
                news.getRank()
        );
        return newsIndexDTO;
    }

    public List<NewsIndexDTO> findNewsByTitle_Like(String title){
        List<News> news = newsDAO.findNewsByTitle_Like("%"+title+"%");
        List<NewsIndexDTO> newsIndexDTOSOS = new ArrayList<NewsIndexDTO>();
        for (News news1:news){
            newsIndexDTOSOS.add(new NewsIndexDTO(
                    news1.getId(),
                    news1.getSrc(),
                    news1.getTitle(),
                    news1.getDate(),
                    news1.getType(),
                    news1.getRank()
            ));
        }
        return newsIndexDTOSOS;
    }

    public List<NewsIndexDTO> findNewsByDate(Date fromDate, Date ToDate) {
        List<News> newsList = newsDAO.findNewsBetweenDate(fromDate,ToDate);
        List<NewsIndexDTO> newsIndexDTOSOS = new ArrayList<NewsIndexDTO>();
        for (News news1:newsList){
            newsIndexDTOSOS.add(new NewsIndexDTO(
                    news1.getId(),
                    news1.getSrc(),
                    news1.getTitle(),
                    news1.getDate(),
                    news1.getType(),
                    news1.getRank()
            ));
        }
        return newsIndexDTOSOS;
    }

    public List<CommentDTO> findAllComments() {
        List<Comment> comments = commentDAO.findAllComments();
        List<CommentDTO> commentDTOS = new ArrayList<CommentDTO>();
        for(Comment comment:comments){
            commentDTOS.add(new CommentDTO(
                    comment.getId(),
                    String.valueOf(comment.getUserId()),
                    String.valueOf(comment.getNewsId()),
                    comment.getContent(),
                    String.valueOf(comment.getTime())
            ));
        }
        return commentDTOS;
    }

    public int commentPageCount() {
        List<CommentDTO> commentDTOS = findAllComments();
        int rest = commentDTOS.size() % CommentPageSize;
        int count = commentDTOS.size() / CommentPageSize;
        int pageCount;
        if (rest == 0){
            pageCount = count;
        }
        else{
            pageCount = count + 1;
        }

        return pageCount;
    }

    public List<CommentDTO> commentPagination(int pageCode, String addr) {

        commentMap.put(addr, findAllComments());
        List<CommentDTO> commentDTOS = commentMap.get(addr);
        List<CommentDTO> commentDTOList = new ArrayList<CommentDTO>();
        int from = (pageCode - 1) * CommentPageSize;
        for (int i = from; i < from + CommentPageSize; ++i) {
            try {
                commentDTOList.add(commentDTOS.get(i));
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return commentDTOList;
    }

    public boolean deleteCommentByUserAndNewsId(int userId, int newsId){
        int result = commentDAO.deleteCommentByNews_IdAndUser_Id(newsId, userId);
        System.out.println(result!=0);
        return result!=0;
    }

    public boolean deleteCommentByUserId(int userId) {
        int result = commentDAO.deleteCommentByUser_Id(userId);
        return result!=0;
    }

    public boolean deleteCommentByNewsId(int newsId) {
        int result = commentDAO.deleteCommentByNews_Id(newsId);
        return result!=0;
    }

    public CommentDTO  findCommentById(int id){
        Comment comment = commentDAO.findCommentById(id);
        CommentDTO commentDTO = new CommentDTO(
                comment.getId(),
                String.valueOf(comment.getUserId()),
                String.valueOf(comment.getNewsId()),
                comment.getContent(),
                String.valueOf(comment.getTime())
        );
        return commentDTO;
    }

    public List<CommentDTO>  findCommentByNewsId(int newsId){
        List<Comment> comments = commentDAO.findCommentByNews_Id(newsId);
        List<CommentDTO> commentDTOS = new ArrayList<CommentDTO>();
        for (Comment comment:comments){
            commentDTOS.add(new CommentDTO(
                    comment.getId(),
                    String.valueOf(comment.getUserId()),
                    String.valueOf(comment.getNewsId()),
                    comment.getContent(),
                    String.valueOf(comment.getTime())
            ));
        }
        return commentDTOS;
    }

    public List<CommentDTO> findCommentByUserId(int userId) {
        List<Comment> comments = commentDAO.findCommentByUser_Id(userId);
        List<CommentDTO> commentDTOS = new ArrayList<CommentDTO>();
        for (Comment comment:comments){
            commentDTOS.add(new CommentDTO(
                    comment.getId(),
                    String.valueOf(comment.getUserId()),
                    String.valueOf(comment.getNewsId()),
                    comment.getContent(),
                    String.valueOf(comment.getTime())
            ));
        }
        return commentDTOS;
    }
}

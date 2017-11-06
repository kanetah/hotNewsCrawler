package top.kanetah.hotNewsCrawler.dao;

import org.springframework.stereotype.Repository;
import top.kanetah.hotNewsCrawler.model.User;

import java.util.List;

/**
 * created by kane on 2017/11/6.
 */
@Repository("userDao")
public interface UserDAO {

    /**
     * 增加一位用户
     *
     * @param user 用户实体
     * @return 被影响的总行数
     */
    int insertUser(User user);

    /**
     * 删除所有用户
     *
     * @return 被影响的总行数
     */
    int deleteAllUser();

    /**
     * 依照用户名删除用户
     *
     * @param name 用户名
     * @return 被影响的总行数
     */
    int deleteUserByName(String name);

    /**
     * 修改一个用户
     *
     * @param user 用户实体
     * @return 被影响的总行数
     */
    int updateUser(User user);

    /**
     * 依照用户名修改用户密码
     *
     * @param user 用户实体
     * @return 被影响的总行数
     */
    int updateUser_PasswordByUser_Name(User user);

    /**
     * 查找所有用户
     *
     * @return 所有用户实体
     */
    List<User> findAllUser();

    /**
     * 通过id查找用户
     *
     * @param id 用户id
     * @return 用户实体
     */
    User findUserById(int id);

    /**
     * 通过用户名查找用户
     *
     * @param name 用户名
     * @return 用户实体
     */
    User findUserByName(String name);
}

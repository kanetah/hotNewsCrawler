package top.kanetah.hotNewsCrawler.service;

/**
 * created by kane on 2017/11/6.
 */
public interface LoginService {

    boolean login(String name, String password);

    boolean logout(String name);

    boolean sign(String name, String password);
}

package top.kanetah.hotNewsCrawler.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * created by kane on 2017/11/6.
 */
public interface LoginService {

    boolean login(String name, String password);

    boolean logout(String name);

    boolean register(String name, String password);

    String backstageLogin(String password, String challenge, String validate, String seccode, HttpServletRequest request);

    void startCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException;
}

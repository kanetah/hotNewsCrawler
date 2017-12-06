package top.kanetah.hotNewsCrawler.service.impl;

import sdk.BackstageConfig;
import org.springframework.stereotype.Service;
import sdk.GeetestLib;
import top.kanetah.hotNewsCrawler.dao.UserDAO;
import top.kanetah.hotNewsCrawler.model.User;
import top.kanetah.hotNewsCrawler.service.LoginService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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

    @Override
    public String backstageLogin(
            String password, String challenge,
            String validate, String seccode,
            HttpServletRequest request
    ) {
        GeetestLib gtSdk = new GeetestLib(
                BackstageConfig.getGeetest_id(), BackstageConfig.getGeetest_key(), BackstageConfig.isNewFailBack());
        HttpSession session = request.getSession();
        int gt_server_status_code = (Integer) session.getAttribute(gtSdk.gtServerStatusSessionKey);
        int gtResult;
        if (gt_server_status_code == 1) //gt-server正常，向gt-server进行二次验证
            gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode);
        else //非正常，进行fail back模式验证
            gtResult = gtSdk.failbackValidateRequest(challenge, validate, seccode);
        boolean flag = gtResult == 1 && BackstageConfig.verify(password);
        session.setAttribute("backstage", flag ? Boolean.TRUE : Boolean.FALSE);
        return flag ? "success" : "fail";
    }

    @Override
    public void backstageLogout(HttpServletRequest request) {
        request.getSession().setAttribute("backstage", Boolean.FALSE);
    }

    @Override
    public void startCaptcha(HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        GeetestLib gtSdk = new GeetestLib(BackstageConfig.getGeetest_id(), BackstageConfig.getGeetest_key(),
                BackstageConfig.isNewFailBack());
        String resStr;
        int gtServerStatus = gtSdk.preProcess();
        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
        resStr = gtSdk.getResponseStr();
        PrintWriter out = response.getWriter();
        out.println(resStr);
    }
}

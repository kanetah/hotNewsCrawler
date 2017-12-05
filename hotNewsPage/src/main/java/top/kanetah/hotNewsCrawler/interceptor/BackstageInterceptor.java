package top.kanetah.hotNewsCrawler.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BackstageInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("===========HandlerInterceptor1 preHandle");

        HttpSession session = httpServletRequest.getSession();
        Boolean backstageState = (Boolean)session.getAttribute("backstage");
        if(backstageState == null || !backstageState)
            httpServletRequest.getRequestDispatcher("backstageLogin.jsp").forward(httpServletRequest,httpServletResponse);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("===========HandlerInterceptor1 postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("===========HandlerInterceptor1 afterCompletion");
    }
}

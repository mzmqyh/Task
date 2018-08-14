package spring.Interceptor;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import spring.service.IuserService;
import spring.service.RmiService;
import utils.CookieUtil;
import utils.Token;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RmiService rmiService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie cookie = CookieUtil.getCookie("login",request);
        IuserService userService = rmiService.getUserService();
        if (cookie==null){
            response.sendRedirect(request.getContextPath()+"/");
            return false;
        }else {
            String value = cookie.getValue();
            String name = Token.parseJWT(value).getId();
            String tokenDate = Token.parseJWT(value).getSubject();
            String date = userService.getName(name).toString();
            if(date.equals(tokenDate)){
                return true;
            }else {
                return false;
            }
        }
    }
}

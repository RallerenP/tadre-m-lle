package com.mchg.tadremoelle.interceptors;

import com.mchg.tadremoelle.annotations.AuthGuard;
import com.mchg.tadremoelle.models.User;
import com.mchg.tadremoelle.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AuthGuardInterceptor implements HandlerInterceptor {
    private final UserService userService;

    public AuthGuardInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            if (handlerMethod.hasMethodAnnotation(AuthGuard.class)) {
                HttpSession session = request.getSession();
                User u = (User) session.getAttribute("user");

                if (u == null) {
                    response.setStatus(401);
                    response.sendRedirect("/login.html");
                    return false;
                }
            }
        }
        return true;
    }


}

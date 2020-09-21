package com.exp.spike.config.resolver;

import com.exp.spike.domain.MiaoshaUser;
import com.exp.spike.service.BasicService;
import com.exp.spike.service.MiaoshaUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: UserArgumentResolver
 * @Description:
 * @Author: Jackson Peh
 * @CreateTime: 2020-09-21 21:08
 * @Version: 1.0
 **/
@Service
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private MiaoshaUserService userService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> clazz = parameter.getParameterType();
        return clazz == MiaoshaUser.class;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        /**
         *  将登录后获取cookie中的内容
         */
        String paramToken = request.getParameter(BasicService.COOKIE_NAME_TOKEN);
        String cookieToken = getCookieValue(request,BasicService.COOKIE_NAME_TOKEN);
        if (StringUtils.isBlank(cookieToken) && StringUtils.isBlank(paramToken)) {
            return null;
        }
        String token = StringUtils.isNotBlank(cookieToken) ? cookieToken : paramToken;
        MiaoshaUser user = userService.getByToken(response,token);
        return user;
    }

    /**
     *  获取cookie中的参数
     * @param request
     * @param cookieName
     * @return
     */
    private String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}

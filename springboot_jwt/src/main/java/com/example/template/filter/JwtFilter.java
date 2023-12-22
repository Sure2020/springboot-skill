/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : JwtFilter
 * Date Created : 2023-12-22
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-12-22       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.template.filter;

/**
 * @program: com.example.template.filter
 * @description: xxx
 * @author: w15021
 * @create: 2023-12-22
 **/

import com.auth0.jwt.interfaces.Claim;
import com.example.template.util.JwtUtil;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * JWT过滤器，拦截 /secure的请求
 */
@Configuration
@WebFilter(filterName = "JwtFilter", urlPatterns = "/secure/*")
public class JwtFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        response.setCharacterEncoding("UTF-8");
        //获取 header里的token
        final String token = request.getHeader("authorization");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request, response);
        }
        // Except OPTIONS, other request should be checked by JWT
        else {

            if (token == null) {
                response.getWriter().write("没有token！");
                return;
            }

            Map<String, Claim> userData = JwtUtil.verifyToken(token);
            if (userData == null) {
                response.getWriter().write("token不合法！");
                return;
            }
            Integer id = userData.get("id").asInt();
            String userName = userData.get("userName").asString();
            String password= userData.get("password").asString();
            //拦截器 拿到用户信息，放到request中
            request.setAttribute("id", id);
            request.setAttribute("userName", userName);
            request.setAttribute("password", password);
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
    }
}
package org.example.tliaswebmanagement.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.EntityClass.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.tliaswebmanagement.Utils.JwtUtil;

import java.io.IOException;

@Slf4j
//@WebFilter("/*")
public class TokenFilter implements Filter {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("资源初始化......");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String URI = httpServletRequest.getRequestURI();

        if(URI.contains("/login")){
            log.info("登录请求，放行");
            chain.doFilter(request, response);
            return;
        }
        String token = httpServletRequest.getHeader("token");
        if(token == null || token.isEmpty()){
            log.info("缺失token，需要重新登录");
            httpServletResponse.setStatus(401);
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(OBJECT_MAPPER.writeValueAsString(Result.Defeat("缺失token，请重新登录")));
            return;
        }
        try{
            log.info("校验token");
            JwtUtil.verifyToken(token);
            log.info("校验通过");
            chain.doFilter(request,response);
            return;
        }catch(Exception e){
            log.info("校验失败");
            httpServletResponse.setStatus(401);
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            httpServletResponse.getWriter().write(OBJECT_MAPPER.writeValueAsString(Result.Defeat("校验失败")));
            return;
        }
    }

    @Override
    public void destroy() {
        log.info("资源销毁......");
    }
}

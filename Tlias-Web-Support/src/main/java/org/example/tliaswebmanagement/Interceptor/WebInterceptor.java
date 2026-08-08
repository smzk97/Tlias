package org.example.tliaswebmanagement.Interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.tliaswebmanagement.EntityClass.Result;
import org.example.tliaswebmanagement.Utils.JwtUtil;
import org.example.tliaswebmanagement.Utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class WebInterceptor implements HandlerInterceptor {

    private ObjectMapper objectMapper;
    @Autowired
    public WebInterceptor(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if(token == null || token.isEmpty()){
            log.info("缺失token，请重新登录");
            response.setStatus(401);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(Result.Defeat("缺失token，请重新登录")));
            return false;
        }

        try{
            log.info("校验token");
            Claims claims = JwtUtil.verifyToken(token);
            ThreadLocalUtil.setCurrentId(claims.get("id"));
            log.info("校验通过");
            return true;
        }catch(Exception e){
            log.info("校验失败");
            response.setStatus(401);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(Result.Defeat("token校验失败，请重新登录")));
            return false;
        }
    }
}

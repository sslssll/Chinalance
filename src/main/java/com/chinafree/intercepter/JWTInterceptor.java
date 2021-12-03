package com.chinafree.intercepter;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.chinafree.common.utils.JWTUtils;
import com.google.common.base.VerifyException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,String> map = new HashMap<>();

        String token = request.getHeader("token");
        try {
            JWTUtils.verify(token);
            return true;
        }catch (SignatureVerificationException e){
            throw new VerifyException("无效签名");
        }catch (AlgorithmMismatchException e){
            throw new VerifyException("token过期");
        }catch (Exception e){
            throw new VerifyException("token无效");
        }
    }
}

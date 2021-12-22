package com.chinafree.intercepter;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.chinafree.common.utils.JWTUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        try {
            JWTUtils.verify(token);
            return true;
        }catch (SignatureVerificationException e){
            response.sendError(403,"无效签名");
            return false;
        }catch (AlgorithmMismatchException e){
            response.sendError(403,"token过期");
            return false;
        }catch (Exception e){
            response.sendError(403,"token无效");
            return false;
        }
    }
}

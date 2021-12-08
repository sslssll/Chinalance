package com.chinafree.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.base.VerifyException;
import lombok.SneakyThrows;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Map;

public class JWTUtils {

    private final static String SALT="is#@duf&d234fzxfslf";

    /**
     * 生成token
     */
    public static String  getToken(Map<String,String> map)  {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,7);//7天过期
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        String token = null;
        try {
            token = builder.withExpiresAt(instance.getTime())
                    .sign(Algorithm.HMAC256(SALT));
        } catch (UnsupportedEncodingException e) {
            throw new VerifyException("生成token错误");
        }
        return token;
    }

    /**
     * 验证token
     */
    public static void verify(String token) throws UnsupportedEncodingException {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SALT)).build().verify(token);
    }

    /**
     * 获取token信息
     */
    public static DecodedJWT getTokenInfo(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(SALT)).build().verify(token);
        } catch (UnsupportedEncodingException e) {
            throw new VerifyException("token验证失败");
        }
    }


}

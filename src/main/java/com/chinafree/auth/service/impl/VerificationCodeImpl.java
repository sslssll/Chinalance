package com.chinafree.auth.service.impl;

import com.chinafree.auth.exception.BusinessException;
import com.chinafree.auth.service.VerificationCode;
import com.chinafree.common.model.enumeration.ResponseCodeEnum;
import com.chinafree.common.model.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationCodeImpl implements VerificationCode {

    private static final String CODE = "_CODE_";
    private static final String TIMES = "_TIME_";

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 发送验证码最多只能发送三次，每次间隔1min，超过三次后过2h才能再发送。
     *
     * @param name
     * @param phoneNumber
     * @return
     */
    @Override
    public BaseResponse sendRegisterVerificationCode(String name, String phoneNumber) {
        if (redisTemplate.hasKey(name + CODE + phoneNumber)) {
            return new BaseResponse(ResponseCodeEnum.SUCCESS, "上次验证码发送,还没超过1min");
        }

        if (redisTemplate.hasKey(name + TIMES + phoneNumber) && (Integer) redisTemplate.opsForValue().get(name + TIMES + phoneNumber) >= 3) {
            return new BaseResponse(ResponseCodeEnum.SUCCESS, "验证码发送次数超过3次，请两个小时之后才试");
        }
        //随机验证码
//        String s = Integer.valueOf((int) Math.random() * 1000000).toString();
        String s = "000000";
        //发送短信
        /*



         */
        redisTemplate.opsForValue().set(name + CODE + phoneNumber, s, 1, TimeUnit.MINUTES);
        //将验证码放在缓存里
        redisTemplate.opsForValue().setIfAbsent(name + TIMES + phoneNumber, 0);
        Integer time = (Integer) redisTemplate.opsForValue().get(name + TIMES + phoneNumber);
        redisTemplate.opsForValue().set(name + TIMES + phoneNumber, time, 2, TimeUnit.HOURS);

        return new BaseResponse(ResponseCodeEnum.SUCCESS, "已发送验证码");
    }


    @Override
    public void checkVerificationCode(String name, String phoneNumber, String vertifivationCode) {
        if (!redisTemplate.hasKey(name + CODE + phoneNumber)) {
            throw new BusinessException(ResponseCodeEnum.FORBIDDEN.toString(), "未发送验证码");
        }
        String verification = (String) redisTemplate.opsForValue().get(name+CODE + phoneNumber);
        if (!verification.equals(vertifivationCode)) {
            throw new BusinessException(ResponseCodeEnum.FORBIDDEN.toString(), "验证码错误");
        }
    }

}

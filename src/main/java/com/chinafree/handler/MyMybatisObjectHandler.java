package com.chinafree.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Component
public class MyMybatisObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ---------");
//        if (metaObject.hasGetter("creatTime") && metaObject.hasGetter("updateTime")) {
            log.info("------1:{}---------",metaObject.hasGetter("createTime"));
            this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
            log.info("----------2:{}---------",metaObject.hasGetter("updateTime"));
            this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
            log.info("------------3-----------");
//        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}

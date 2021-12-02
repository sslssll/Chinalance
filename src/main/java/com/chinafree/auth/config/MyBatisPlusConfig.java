package com.chinafree.auth.config;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan("com.chinafree.auth.mapper")
@EnableTransactionManagement
@Configuration
public class MyBatisPlusConfig {
    /**
     * 乐观锁插件
     *
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }


    @Bean
    public PaginationInnerInterceptor paginationInterceptor(){
        return new PaginationInnerInterceptor();
    }


    @Bean
    @Profile({"dev","test"})
    public PerformanceMonitorInterceptor performanceMonitorInterceptor(){
        PerformanceMonitorInterceptor performance = new PerformanceMonitorInterceptor();
//        performance.setLogTargetClassInvocation(/);
        return performance;
    }
}



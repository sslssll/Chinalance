//package com.chinafree.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// *主要是权限配置
// */
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//    /**
//     * 拦截下面的东西
//     *
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll() //主路径允许访问
//                .anyRequest().authenticated()  //验证
//                .and()
//                .logout().permitAll() //注销也是运行访问
//                .and()
//                .formLogin();
//        http.csrf().disable();  //关闭csrf() 认证
//    }
//
//    /**
//     * 不拦截下面这些资源
//     *
//     * @param web
//     * @throws Exception
//     */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
//    }
//
//    /**
//     * 基于内存的验证：不需要用到数据库的情况
//     *
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //我们指定一个人这个人的用户：admin 密码：123456  角色：ADMIN
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN");
//
//    }
//
//    /**
//     * 只有ADMIN 的角色才能访问
//     * @return
//     */
//    @PreAuthorize("hasRole('ROLE_ADMIN')")//必须用ROLE_xxx  才能识别你是做角色权限
//    @RequestMapping("/roleAuth")
//    public String role () {
//        return "需要某个权限才能访问";
//    }
//
//
//
//}

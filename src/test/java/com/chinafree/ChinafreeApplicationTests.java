package com.chinafree;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chinafree.auth.controller.LoginUserRestController;
import com.chinafree.auth.controller.RegisterController;
import com.chinafree.auth.model.param.LoginParam;
import com.chinafree.auth.model.param.RegistrationParam;
import com.chinafree.auth.model.po.SysLoginUser;
import com.chinafree.auth.model.result.LoginResult;
import com.chinafree.common.model.request.RequestParameter;
import com.chinafree.common.model.response.EntityResponse;
import com.chinafree.mapper.SysLoginUserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class ChinafreeApplicationTests {

    @Autowired
    private SysLoginUserMapper userMapper;

    @Test
    void contextLoads() {
        //select
        QueryWrapper<SysLoginUser> loginUserQueryWrapper = new QueryWrapper<>();
//        loginUserQueryWrapper.eq("login_mail","1831027552@qq.com");

        List<SysLoginUser> loginUsers = userMapper.selectList(null);
        System.out.println("------------------------------------------------------");
        loginUsers.forEach(System.out::println);

    }

    @Test
    public void testInsert() {
        SysLoginUser build = SysLoginUser.builder().loginMail("123213@11.com").loginName("87e656").build();
        int insert = userMapper.insert(build);
        System.out.println("-----------tet---------");
        System.out.println(insert);
    }

    @Test
    public void testBatchInsert() {
        SysLoginUser build = SysLoginUser.builder().loginMail("123213@11.com").loginName("87e656").build();
        int insert = userMapper.insert(build);
        System.out.println("-----------tet---------");
        System.out.println(insert);
    }


    @Test
    public void testUpdate() {
//        BaseEntity.builder().id(8L);
        int i = userMapper.updateById(SysLoginUser.builder().loginName("000").build());
        System.out.println(i);
    }

    @Test
    public void testOptimisticLocker() {
        //成功
        SysLoginUser user = userMapper.selectById(1L);
        user.setLoginName("111111");
        SysLoginUser user2 = userMapper.selectById(1L);
        user2.setLoginName("22222");
        userMapper.updateById(user2);
        userMapper.updateById(user);

    }

    //-------------select---------------------//
    @Test
    public void testSelectBatchIds() {
        List<SysLoginUser> loginUsers = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        loginUsers.forEach(System.out::println);
    }

    //条件查询
    @Test
    public void testSelect() {
        HashMap<String, Object> map = new HashMap<>();
        //自定义
        map.put("login_name", "22222");
        List<SysLoginUser> loginUsers = userMapper.selectByMap(map);
        loginUsers.forEach(System.out::println);

    }


    //分页查询
    @Test
    public void testPage() {
        Page<SysLoginUser> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
    }

    //删除
    @Test
    public void testDelete() {
//        userMapper.deleteById(3L);
        userMapper.deleteBatchIds(Arrays.asList(6L, 7L));
    }


    @Test
    public void testWrapSelect() {
//        QueryWrapper<SysLoginUser> loginUserQueryWrapper = new QueryWrapper<>();
////        loginUserQueryWrapper.isNotNull("login_name").isNotNull("login_mail").eq("id", "1L");
////        userMapper.selectList(loginUserQueryWrapper);
//        loginUserQueryWrapper.eq(Column.LOGIN_MAIL.getColumn(), "1831027522@qq.com");
//        SysLoginUser user = userMapper.selectOne(loginUserQueryWrapper);
//        String hash = MD5Utils.hash("12345678");
//        System.out.println(hash);

    }



    @Autowired
    RegisterController registerController;
    @Test
    public void registration(){
        String phone = "17367115251";
        registerController.sendRegisterVerificationCode(phone);
        RegistrationParam registrationParam = new RegistrationParam();
        registrationParam.setPassword("111111111");
        registrationParam.setVerification("000000");
        registrationParam.setPhoneNumber(phone);
        registerController.registerByPhoneAndCode(new RequestParameter<>(registrationParam));

    }

    @Autowired
    LoginUserRestController loginUserRestController;

    @Test
    public void login(){
        LoginParam loginParam = new LoginParam();
        loginParam.setPassword("000000");
        loginParam.setUsername("17367115251");
//        loginUserRestController.emailLogin(new RequestParameter<>(loginParam));

        loginUserRestController.sendLoginVerfication("17367115251");
        EntityResponse<LoginResult> loginResultEntityResponse = loginUserRestController.LoginByPhoneAndVerfication(new RequestParameter<>(loginParam));


    }


}

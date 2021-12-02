package com.chinafree.auth.mapping;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chinafree.auth.model.bo.LoginUserBo;
import com.chinafree.auth.model.enumeration.Column;
import com.chinafree.auth.model.po.SysLoginUser;
import com.chinafree.auth.model.po.SysThirdPartAccount;
import com.chinafree.auth.model.result.ThirdPartAccountResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface LoginUserMapping {


    LoginUserMapping loginUserMapping = Mappers.getMapper(LoginUserMapping.class);


    LoginUserBo sysLoginUserToBo(SysLoginUser sysLoginUser);


    ThirdPartAccountResult thirdPartAccountToResult(SysThirdPartAccount sysThirdPartAccount);


    default List<ThirdPartAccountResult> thirdPartAccountsToResult(List<SysThirdPartAccount> sysThirdPartAccountList){
        return sysThirdPartAccountList.stream().map(LoginUserMapping.loginUserMapping::thirdPartAccountToResult).collect(Collectors.toList());
    }


}

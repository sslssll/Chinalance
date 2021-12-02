package com.chinafree.dao;

import com.chinafree.entity.sysThirdPartyAccount;

public interface sysThirdPartyAccountMapper {
    int insert(sysThirdPartyAccount record);

    int insertSelective(sysThirdPartyAccount record);
}
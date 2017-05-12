package com.renlg.user.dao;

import com.renlg.user.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * 通过账号密码查询用户
     * @param record
     * @return
     */
    User selectByUserNameAndPass(User record);
}

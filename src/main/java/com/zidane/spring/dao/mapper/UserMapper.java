package com.zidane.spring.dao.mapper;

import com.zidane.spring.domain.User;

import java.util.List;

/**
 * 用户相关操作Mapper
 *
 * @author Zidane
 * @since 2018-04-08
 */
public interface UserMapper {
    void insert(User user);

    void update(User user);

    User getUserByName(String userName);

    User getUserById(String userName);

    List<User> queryAllUser();
}


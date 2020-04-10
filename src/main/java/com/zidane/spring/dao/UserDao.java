package com.zidane.spring.dao;

import com.zidane.spring.dao.mapper.UserMapper;
import com.zidane.spring.domain.User;

import groovy.util.logging.Slf4j;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * User对象Dao层数据操作类
 *
 * @author Zidane
 * @since 2018-04-08
 */
@Slf4j
@Repository
public class UserDao {
    private final Logger logger = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名称查询用户信息
     *
     * @param userName userName
     * @return User 用户信息
     */
    public User getUserByName(String userName) {
        logger.debug("The user name is: ", userName);

        return userMapper.getUserByName(userName);
    }

    /**
     * 根据用户ID查询用户信息
     *
     * @param userId userId
     * @return User 用户信息
     */
    public User getUserById(String userId) {
        logger.debug("The user id is: ", userId);

        return userMapper.getUserById(userId);
    }

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     */
    public void create(User user) {
        logger.debug("Begin to create user, user is {}", user);
        userMapper.insert(user);
        logger.debug("Create user info successed.", user);
    }

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     */
    public void update(User user) {
        logger.debug("Begin to update user info, user info is {}", user);
        userMapper.update(user);
        logger.debug("Update user info successed.", user);
    }

    /**
     * 查询所有用户信息
     *
     * @return List<User> 所有用户信息
     */
    public List<User> queryAllNormalUser() {
        logger.debug("Begin to query all user info.");
        List<User> users = userMapper.queryAllUser();
        logger.debug("Query all user successed.", users);
        return users;
    }

}

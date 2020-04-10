package com.zidane.spring.dao;

import com.zidane.spring.dao.mapper.LoginMapper;
import com.zidane.spring.domain.LoginLog;

import groovy.util.logging.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 记录登录信息的DAO类
 *
 * @author Zidane
 * @since 2018-04-08
 */
@Slf4j
@Repository
public class LoginDao {
    private final Logger logger = LoggerFactory.getLogger(LoginDao.class);

    @Autowired
    private LoginMapper userMapper;

    /**
     * 记录客户登录的信息
     *
     * @param loginLog 用户登录记录
     */
    public void insert(LoginLog loginLog) {
        logger.debug("The user id is: ", loginLog.getUserId());
        userMapper.insert(loginLog);
    }
}

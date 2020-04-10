package com.zidane.spring.service;

import com.zidane.spring.dao.LoginDao;
import com.zidane.spring.domain.LoginLog;
import com.zidane.spring.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录管理服务，负责记录登录信息等操作
 *
 * @author Zidane
 * @since 2018-04-08
 */
@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    /**
     * 登陆成功
     * @param user
     */
    public void loginSuccess(User user) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        loginDao.insert(loginLog);
    }
}
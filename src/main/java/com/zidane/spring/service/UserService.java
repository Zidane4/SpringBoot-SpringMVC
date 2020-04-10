package com.zidane.spring.service;

import com.zidane.spring.dao.UserDao;
import com.zidane.spring.domain.User;
import com.zidane.spring.exception.UserExistException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户管理服务，负责查询用户、注册用户、锁定用户等操作
 *
 * @author Zidane
 * @since 2018-04-08
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 注册一个新用户,如果用户名已经存在此抛出UserExistException的异常
     *
     * @param user 用户信息
     */
    public void register(User user) throws UserExistException {
        User u = this.getUserByUserName(user.getUserName());
        if (u != null) {
            throw new UserExistException("用户名已经存在");
        } else {
            user.setCredit(100);
            user.setUserType(0);
            userDao.create(user);
        }
    }

    /**
     * 更新用户
     *
     * @param user
     */
    public void updateUserInfo(User user) {
        userDao.update(user);
    }

    /**
     * 根据用户名/密码查询用户信息
     *
     * @param userName  用户名
     * @return User     用户信息
     */
    public User getUserByUserName(String userName) {
        return userDao.getUserByName(userName);
    }

    /**
     * 根据userId加载User对象
     *
     * @param   userId   用户ID
     * @return  User     用户信息
     */
    public User getUserByUserId(String userId) {
        return userDao.getUserById(userId);
    }

    /**
     * 将用户锁定，锁定的用户不能够登录
     *
     * @param userName 锁定目标用户的用户名
     * @param locked   锁定或解锁的标识位：0-解锁；1-锁定
     */
    public void lockUser(String userName, String locked) throws UserExistException {
        User user = userDao.getUserByName(userName);

        if (user == null) {
            throw new UserExistException("The user is not exist.");
        }

        user.setLocked(Integer.valueOf(locked));
        userDao.update(user);
    }

    /**
     * 获取所有用户
     *
     * @return 所有用户
     */
    public List<User> getAllUsers() {
        return userDao.queryAllNormalUser();
    }
}

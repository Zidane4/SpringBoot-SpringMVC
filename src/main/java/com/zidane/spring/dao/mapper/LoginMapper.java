package com.zidane.spring.dao.mapper;

import com.zidane.spring.domain.LoginLog;

/**
 * 登录相关操作Mapper
 *
 * @author Zidane
 * @since 2018-04-08
 */
public interface LoginMapper {
    void insert(LoginLog loginLog);
}

package com.zidane.spring.domain;

import java.util.Date;

/**
 * 登录信息pojo
 *
 * @author Zidane
 * @since 2018-04-08
 */
public class LoginLog {
    private int loginLogId;

    private Date loginDate;

    private int userId;

    private String ip;

    public int getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "LoginLog{" + "loginLogId=" + loginLogId + ", loginDate=" + loginDate + ", userId='" + userId + '\''
                + ", ip='" + ip + '\'' + '}';
    }
}

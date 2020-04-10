package com.zidane.spring.exception;

/**
 * 登录异常
 *
 * @author Zidane
 * @since 2018-04-08
 */
public class NotLoginException extends RuntimeException {
    public NotLoginException(String errorMsg) {
        super(errorMsg);
    }
}

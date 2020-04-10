package com.zidane.spring.exception;

/**
 * 用户异常
 *
 * @author Zidane
 * @since 2018-04-08
 */
public class UserExistException extends Exception
{
    public UserExistException(String errorMsg)
    {
        super(errorMsg);
    }
}

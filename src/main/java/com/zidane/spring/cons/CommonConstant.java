package com.zidane.spring.cons;

/**
 * 系统常量
 *
 * @author Zidane
 * @since 2018-04-08
 */
public class CommonConstant
{
   /**
    * 用户对象放到Session中的键名称
    */
   public static final String USER_CONTEXT = "USER_CONTEXT";

   /**
    * 被锁定用户对应的状态值
    */
   public static final int USER_LOCK = 1;

   /**
    * 超级管理员用户类型
    */
   public static final int ADMIN_USER = 1;

   /**
    * 返回页面错误信息对应的key值
    */
   public static final String ERROR_MSG_KEY = "errorMsg";
}

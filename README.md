# 系统整体介绍
本工程是基于springboot+springmvc框架实现的。

## 业务简介
本系统的业务场景为一个简单的用户登录和管理系统，整体框架为springboot，前端的实现依赖springmvc框架。
具体的使用方式：
* 执行启动类SpringBootStartApplication
* 直接通过浏览器访问链接：http://localhost:10501/register
可以直接在页面进行用户注册。
* 如果用超级管理员（账号：admin密码：admin）登录系统（登录链接：http://localhost:10501/login/doLogin），
则可以对各个普通账号进行锁定和解锁操作。被锁定的用户，是无法登录系统的。
每次用户登录，系统都会记录登录信息至数据库。

## 数据库
* 使用前首先要在本地安装数据库，本系统使用的是mysql，具体的安装可参考链接：
https://blog.csdn.net/weixin_40396510/article/details/79277731
* 安装完成后，在配置文件application.properties中设置数据库信息，并执行sql文件create_db，创建数据库表。

## 工程模块
```
├── README.md
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com.zidane.spring
    │   │       ├── web--对应三层结构的接口层(依赖SpringMVC框架进行前后台交互)
    │   │       │
    │   │       ├── service--对应三层结构的业务层
    │   │       │
    │   │       ├── dao--对应三层结构的持久层
    │   │       │
    │   │       └── domain--对应持久层的pojo
    │   │
    │   ├── resources
    │   │   ├── application.properties
    │   │   ├── log4j.xml
    │   │   └── transaction.xml--事务的配置文件
    │   │   └── webapp--包含所有jsp文件
    │   │   └── mybatis
    │   │ 	    └── mapping--mybatis的Mapper.xml配置文件
    │   │
    │   │
    └── test
        └── java

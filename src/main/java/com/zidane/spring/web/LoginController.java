package com.zidane.spring.web;

import com.zidane.spring.cons.CommonConstant;
import com.zidane.spring.domain.User;
import com.zidane.spring.service.LoginService;
import com.zidane.spring.service.UserService;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录信息管理
 *
 * @author Zidane
 * @since 2018-04-08
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
    /**
     * 用户账户服务
     */
    @Autowired
    private UserService userService;

    /**
     * 用户登录服务
     */
    @Autowired
    private LoginService loginService;

    /**
     * 用户登陆
     *
     * @param  request      http请求
     * @return User         用户信息
     * @return ModelAndView 视图模型
     */
    @RequestMapping("/doLogin")
    public ModelAndView login(HttpServletRequest request, User user) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");

        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
            mav.addObject(CommonConstant.ERROR_MSG_KEY, "请输入用户名和密码");
            return mav;
        }

        User dbUser = userService.getUserByUserName(user.getUserName());
        if (dbUser == null) {
            mav.addObject(CommonConstant.ERROR_MSG_KEY, "用户不存在");
        } else if (!dbUser.getPassword().equals(user.getPassword())) {
            mav.addObject(CommonConstant.ERROR_MSG_KEY, "用户密码不正确");
        } else if (dbUser.getLocked() == CommonConstant.USER_LOCK) {
            mav.addObject(CommonConstant.ERROR_MSG_KEY, "用户已经被锁定，不能登录。");
        } else {
            dbUser.setLastIp(request.getRemoteAddr());
            dbUser.setLastVisit(new Date());
            dbUser.setCredit(dbUser.getCredit() + 100);
            userService.updateUserInfo(dbUser);
            loginService.loginSuccess(dbUser);
            setSessionUser(request, dbUser);

            // 如果是超级管理员用户，即userType为1时，进入用户账号管理页面
            if (dbUser.getUserType() == CommonConstant.ADMIN_USER) {
                return queryUserList();
            } else {
                mav.setViewName("login_success");
            }
        }

        return mav;
    }

    /**
     * 登录注销
     *
     * @param   session 上下文
     * @return  String  返回登录路径
     */
    @RequestMapping("/doLogout")
    public String logout(HttpSession session) {
        session.removeAttribute(CommonConstant.USER_CONTEXT);
        return "login";
    }

    /**
     * 查询所有用户信息列表
     *
     * @return ModelAndView 视图模型
     */
    private ModelAndView queryUserList() {
        ModelAndView view = new ModelAndView();

        List<User> users = userService.getAllUsers();
        view.addObject("users", users);
        view.setViewName("lock");
        return view;
    }
}

/*
 * Copyright (c) 18-12-2 下午10:05 toxic
 */

package com.toxic.auth.controller;

import com.toxic.auth.model.UserInfo;
import com.toxic.auth.model.query.UserInfoQuery;
import com.toxic.auth.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


/**
 * Title:登录
 * Description:
 *
 * @author py
 * @date 2018/12/2 22:05.
 */
@Controller
@RequestMapping(value = "auth/")
public class LoginController {
    @Resource
    private UserInfoService userInfoService;
    @RequestMapping("/doLogin")
    @ResponseBody
    public String  doLogin(String username, String password) {
        List<UserInfo> userInfoList = userInfoService.queryList(new UserInfoQuery());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            token.clear();
//            return ResultGenerator.genFailResult("登录失败，用户名或密码错误！");
            return "登录失败";
        }
//        return ResultGenerator.genSuccessResult("登录成功");
        return "登录成功";
    }
}

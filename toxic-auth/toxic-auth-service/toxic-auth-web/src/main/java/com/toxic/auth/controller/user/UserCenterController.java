/*
 * Copyright (c) 2018. toxic
 */

package com.toxic.auth.controller.user;

import com.toxic.auth.business.user.UserCenterBusiness;
import com.toxic.auth.model.UserInfo;
import com.toxic.auth.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author py
 * @date 2018/8/31 上午9:52.
 */
@Controller
@RequestMapping("/user")
public class UserCenterController {
    @Resource
    private UserCenterBusiness userCenterBusiness;
    @RequestMapping(value = "/queryList")
    public String toUserList(Model model){
        model.addAttribute("userList",userCenterBusiness.getAllUserInfo());
        return "user/user_list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String toEdit(Model model,String id){
        model.addAttribute("user",userCenterBusiness.getUserInfoByid(id));
        return "user/user_edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo realEdit(UserInfo userInfo){
        ResultVo resultVo = new ResultVo();
        int row = userCenterBusiness.updateUserInfo(userInfo);
        resultVo.setData(row);
        return resultVo;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo addUser(UserInfo userInfo){
        ResultVo resultVo = new ResultVo();
        userCenterBusiness.insertUserInfo(userInfo);
        return new ResultVo();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAddUser(UserInfo userInfo){
        return "user/user_add";
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResultVo deleteUser(Long id){
        userCenterBusiness.deleteUserInfo(id);
        return new ResultVo();
    }
}

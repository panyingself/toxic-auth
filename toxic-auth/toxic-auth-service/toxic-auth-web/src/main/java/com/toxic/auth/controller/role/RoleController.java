/*
 * Copyright (c) 18-12-2 下午10:15 toxic
 */

package com.toxic.auth.controller.role;

import com.toxic.auth.business.role.RoleBusiness;
import com.toxic.auth.model.RoleInfo;
import com.toxic.auth.vo.ResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Title:
 * Description:
 *
 * @author py
 * @date 2018/12/2 22:15.
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleBusiness roleBusiness;
    @RequestMapping(value = "/queryList")
    public String toUserList(Model model){
        model.addAttribute("userList",roleBusiness.getAllRoleInfo());
        return "user/user_list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String toEdit(Model model,String id){
        model.addAttribute("user",roleBusiness.getRoleInfoByid(id));
        return "user/user_edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo realEdit(RoleInfo RoleInfo){
        ResultVo resultVo = new ResultVo();
        int row = roleBusiness.updateRoleInfo(RoleInfo);
        resultVo.setData(row);
        return resultVo;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo addUser(RoleInfo RoleInfo){
        ResultVo resultVo = new ResultVo();
        roleBusiness.insertRoleInfo(RoleInfo);
        return new ResultVo();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAddUser(RoleInfo RoleInfo){
        return "user/user_add";
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResultVo deleteUser(Long id){
        roleBusiness.deleteRoleInfo(id);
        return new ResultVo();
    }
}

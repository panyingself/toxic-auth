/*
 * Copyright (c) 18-12-2 下午10:15 toxic
 */

package com.toxic.auth.controller.permission;

import com.alibaba.fastjson.JSON;
import com.toxic.auth.business.permission.PermissionBusiness;
import com.toxic.auth.business.role.RoleBusiness;
import com.toxic.auth.model.PermissionInfo;
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
@RequestMapping("/permissionconfig")
public class PermissionConfigController {
    @Resource
    private PermissionBusiness permissionBusiness;
    @Resource
    private RoleBusiness roleBusiness;

    @RequestMapping(value = "/queryList")
    public String topermissionList(Model model) {
        model.addAttribute("roles", roleBusiness.getAllRoleInfo());
        return "permissionconifg/permission_config_list";
    }

    @RequestMapping(value = "/updatePermissionListByRoleId", method = RequestMethod.POST)
    @ResponseBody
    public String toEdit( String roleId,String[] permissionIds) {
        String znodes = JSON.toJSONString(permissionBusiness.updateAllZnodeListInfo(permissionIds,roleId));
        return znodes;
    }

    @RequestMapping(value = "/queryPermissionListByRoleId", method = RequestMethod.POST)
    @ResponseBody
    public String realEdit(String roleId) {
        String znodes = JSON.toJSONString(permissionBusiness.getAllZnodeListInfo(roleId));
        return znodes;
    }
}



/*
 * Copyright (c) 18-12-2 下午10:15 toxic
 */

package com.toxic.auth.controller.permission;

import com.toxic.auth.business.permission.PermissionBusiness;
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
@RequestMapping("/permission")
public class PermissionController {
    @Resource
    private PermissionBusiness permissionBusiness;
    @RequestMapping(value = "/queryList")
    public String topermissionList(Model model){
        model.addAttribute("permissionList",permissionBusiness.getAllPermissionInfo());
        return "permission/permission_list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String toEdit(Model model,String id){
        model.addAttribute("permission",permissionBusiness.getPermissionInfoByid(id));
        return "permission/permission_edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo realEdit(PermissionInfo PermissionInfo){
        ResultVo resultVo = new ResultVo();
        int row = permissionBusiness.updatePermissionInfo(PermissionInfo);
        resultVo.setData(row);
        return resultVo;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResultVo addpermission(PermissionInfo PermissionInfo){
        ResultVo resultVo = new ResultVo();
        permissionBusiness.insertPermissionInfo(PermissionInfo);
        return new ResultVo();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAddpermission(PermissionInfo PermissionInfo){
        return "permission/permission_add";
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResultVo deletepermission(Long id){
        permissionBusiness.deletePermissionInfo(id);
        return new ResultVo();
    }
}

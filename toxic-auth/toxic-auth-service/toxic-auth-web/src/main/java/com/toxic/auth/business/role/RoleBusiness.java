/*
 * Copyright (c) 2018. toxic
 */

package com.toxic.auth.business.role;

import com.toxic.auth.model.RoleInfo;
import com.toxic.auth.model.query.RoleInfoQuery;
import com.toxic.auth.service.RoleInfoService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author py
 * @date 2018/12/3 3:59 PM.
 */
@Component
public class RoleBusiness {
    @Resource
    private RoleInfoService roleInfoService;
    /**
     * @param
     * @return java.util.List<com.toxic.job.model.RoleInfo>
     * @author py
     * @date  上午9:57
     * 获取所有权限信息
     * @exception
     */
    public List<RoleInfo> getAllRoleInfo(){
        List<RoleInfo> RoleInfoList = new ArrayList<>();
        try {
            RoleInfoList = roleInfoService.queryList(new RoleInfoQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return RoleInfoList;
    }
    /**
     * 根据proleId获取权限信息
     * @param
     * @return com.toxic.auth.model.RoleInfo
     * @author py
     * @date  4:08 PM
     * @exception
     */
    public RoleInfo getRoleInfoByid(String id){
        RoleInfo RoleInfo = new RoleInfo();
        RoleInfo.setRoleId(id);
        return roleInfoService.selectOne(RoleInfo);
    }

    /**
     * @param
     * @return void
     * @author py
     * @date  下午5:06
     * 修改指定权限
     * @exception
     */
    public int updateRoleInfo(RoleInfo RoleInfo){
        int row = roleInfoService.update(RoleInfo);
        return row;
    }
    /**
      * Method: 
      * Description: 添加RoleInfo
      * Author: py
      * Data: 2018/9/2 14:21
       * @param RoleInfo
      * @return void
      */
    public void insertRoleInfo(RoleInfo RoleInfo){
        roleInfoService.insert(RoleInfo);
    }
    /**
      * Method: 
      * Description: 删除某个RoleInfo
      * Author: py
      * Data: 2018/9/2 14:42
       * @param id
      * @return void
      */
    public void deleteRoleInfo(Long id){
        
    }
}

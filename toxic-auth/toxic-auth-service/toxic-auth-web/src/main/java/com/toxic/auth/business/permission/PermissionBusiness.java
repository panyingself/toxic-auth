/*
 * Copyright (c) 2018. toxic
 */

package com.toxic.auth.business.permission;

import com.toxic.auth.model.PermissionInfo;
import com.toxic.auth.model.query.PermissionInfoQuery;
import com.toxic.auth.service.PermissionInfoService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author py
 * @date 2018/12/3 3:59 PM.
 */
@Component
public class PermissionBusiness {
    @Resource
    private PermissionInfoService permissionInfoService;
    /**
     * @param
     * @return java.util.List<com.toxic.job.model.permissionInfo>
     * @author py
     * @date  上午9:57
     * 获取所有权限信息
     * @exception
     */
    public List<PermissionInfo> getAllPermissionInfo(){
        List<PermissionInfo> permissionInfoList = new ArrayList<>();
        try {
            permissionInfoList = permissionInfoService.queryList(new PermissionInfoQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return permissionInfoList;
    }
    /**
     * 根据permissionId获取权限信息
     * @param
     * @return com.toxic.auth.model.permissionInfo
     * @author py
     * @date  4:08 PM
     * @exception
     */
    public PermissionInfo getPermissionInfoByid(String id){
        PermissionInfo permissionInfo = new PermissionInfo();
        permissionInfo.setResourceId(id);
        return permissionInfoService.selectOne(permissionInfo);
    }

    /**
     * @param
     * @return void
     * @author py
     * @date  下午5:06
     * 修改指定权限
     * @exception
     */
    public int updatePermissionInfo(PermissionInfo permissionInfo){
        int row = permissionInfoService.update(permissionInfo);
        return row;
    }
    /**
      * Method: 
      * Description: 添加permissionInfo
      * Author: py
      * Data: 2018/9/2 14:21
       * @param permissionInfo
      * @return void
      */
    public void insertPermissionInfo(PermissionInfo permissionInfo){
        permissionInfoService.insert(permissionInfo);
    }
    /**
      * Method: 
      * Description: 删除某个permissionInfo
      * Author: py
      * Data: 2018/9/2 14:42
       * @param id
      * @return void
      */
    public void deletePermissionInfo(Long id){
        
    }
}

/*
 * Copyright (c) 2018. toxic
 */

package com.toxic.auth.business.permission;

import com.toxic.auth.model.PermissionInfo;
import com.toxic.auth.model.RolePermission;
import com.toxic.auth.model.query.PermissionInfoQuery;
import com.toxic.auth.model.query.RolePermissionQuery;
import com.toxic.auth.service.PermissionInfoService;
import com.toxic.auth.service.RoleInfoService;
import com.toxic.auth.service.RolePermissionService;
import com.toxic.auth.vo.ztree.Znode;
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
    @Resource
    private RoleInfoService roleInfoService;
    @Resource
    private RolePermissionService rolePermissionService;
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
     * @param
     * @return java.util.List<com.toxic.job.model.permissionInfo>
     * @author py
     * @date  上午9:57
     * 获取所有权限树信息
     * @exception
     */
    public List<Znode> getAllZnodeListInfo(String roleId){
        List<Znode> znodeList = new ArrayList<>();
        try {
            //获取所有权限节点数据-理论上应该只查一次，查出来放入缓存
            List<PermissionInfo> permissionInfoList = permissionInfoService.queryList(new PermissionInfoQuery());
            if( permissionInfoList.size() > 0 ){
                for( PermissionInfo permissionInfo : permissionInfoList ){
                    Znode znode = new Znode();
                    znode.setpId(permissionInfo.getParentId());
                    znode.setId(permissionInfo.getResourceId());
                    znode.setName(permissionInfo.getName());
                    znodeList.add(znode);
                }
            }
            //根据角色id查询拥有的权限信息
            RolePermissionQuery rolePermissionQuery = new RolePermissionQuery();
            rolePermissionQuery.setRoleId(roleId);
            List<RolePermission> rolePermissionList = rolePermissionService.queryList(rolePermissionQuery);
            //查询admin角色拥有的权限
            List<PermissionInfo> adminPermissionInfoList = new ArrayList<>();
            if (rolePermissionList.size() > 0 ){
                for( RolePermission rolePermission : rolePermissionList ){
                    PermissionInfoQuery permissionInfoQuery = new PermissionInfoQuery();
                    permissionInfoQuery.setResourceId(rolePermission.getPermissionId());
                    adminPermissionInfoList.addAll(permissionInfoService.queryList(permissionInfoQuery)) ;
                }
            }
            //admin拥有的权限为选中状态
            for( Znode znode : znodeList ){
                for( PermissionInfo permissionInfo : adminPermissionInfoList ){
                    if( znode.getId().equals(permissionInfo.getResourceId())){
                        znode.setChecked(true);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return znodeList;
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
    public List<Znode> updateAllZnodeListInfo(String roleId){
        List<Znode> znodeList = new ArrayList<>();
        try {
            //step1 查询当前角色以前的权限集合【从缓存中拿】list1
            //step2 比对修改之后的权限list2 : list1
            //step2.1 将集合中都存在的数据放入list3,将修改之后原来list中没有的数据放入list4，list4执行插入操作
            //step2.2 原来的list1和list3做比对操作,如果元素相同则不做变化,如果list1大于list,将大于的部分方法list5,list5做删除操作
        } catch (Exception e) {
            e.printStackTrace();
        }
        return znodeList;
    }
}

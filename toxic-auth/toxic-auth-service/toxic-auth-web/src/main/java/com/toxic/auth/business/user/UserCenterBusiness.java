/*
 * Copyright (c) 2018. toxic
 */

package com.toxic.auth.business.user;

import com.toxic.auth.model.UserInfo;
import com.toxic.auth.model.query.UserInfoQuery;
import com.toxic.auth.service.UserInfoService;
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
public class UserCenterBusiness {
    @Resource
    private UserInfoService userInfoService;
    /**
     * @param
     * @return java.util.List<com.toxic.job.model.UserInfo>
     * @author py
     * @date  上午9:57
     * 获取所有用户信息
     * @exception
     */
    public List<UserInfo> getAllUserInfo(){
        List<UserInfo> userInfoList = new ArrayList<>();
        try {
            userInfoList = userInfoService.queryList(new UserInfoQuery());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfoList;
    }
    /**
     * 根据userId获取用户信息
     * @param
     * @return com.toxic.auth.model.UserInfo
     * @author py
     * @date  4:08 PM
     * @exception
     */
    public UserInfo getUserInfoByid(String id){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(id);
        return userInfoService.selectOne(userInfo);
    }

    /**
     * @param
     * @return void
     * @author py
     * @date  下午5:06
     * 修改指定定时
     * @exception
     */
    public int updateUserInfo(UserInfo userInfo){
        int row = userInfoService.update(userInfo);
        return row;
    }
    /**
      * Method: 
      * Description: 添加userInfo
      * Author: py
      * Data: 2018/9/2 14:21
       * @param userInfo
      * @return void
      */
    public void insertUserInfo(UserInfo userInfo){
        if( null != userInfo){
            userInfo.setCreateDateTime(new Date());
        }
        userInfoService.insert(userInfo);
    }
    /**
      * Method: 
      * Description: 删除某个userInfo
      * Author: py
      * Data: 2018/9/2 14:42
       * @param id
      * @return void
      */
    public void deleteUserInfo(Long id){
        
    }
}

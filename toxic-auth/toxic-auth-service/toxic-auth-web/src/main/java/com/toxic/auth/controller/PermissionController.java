/*
 * Copyright (c) 18-12-2 下午10:15 toxic
 */

package com.toxic.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value = "/test")
    @ResponseBody
    public String testGetPermission(){
        return "permission success";
    }
}

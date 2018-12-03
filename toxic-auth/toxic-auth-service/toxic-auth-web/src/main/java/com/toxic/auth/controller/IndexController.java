package com.toxic.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author py
 * @date 2018/12/3 11:30 AM.
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping(value = "/index")
    private String toIndex(){
        return "index";
    }
}

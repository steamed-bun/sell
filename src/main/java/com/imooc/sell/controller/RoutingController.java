package com.imooc.sell.controller;

import com.imooc.sell.OV.ResultOV;
import com.imooc.sell.utils.ResultOVUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 前端路由转发
 * @author: WangXue
 * @create: 2018-11-07 20:23
 */
@RestController
public class RoutingController {

    @GetMapping(value = "login")
    public ResultOV login() {
        return ResultOVUtil.success("cfff");
    }

    @GetMapping(value = "/logout")
    public ResultOV logout() {
//        Subject subject = SecurityUtils.getSubject();
//        if(subject.getPrincipals() != null) {
//            UserDto user = (UserDto)subject.getPrincipals().getPrimaryPrincipal();
//            userService.deleteLoginInfo(user.getUsername());
//        }
//        SecurityUtils.getSubject().logout();
        System.out.println("logout");
        return ResultOVUtil.success("logout");
    }

    @GetMapping(value = "login-error")
    public ResultOV loginTo() {
        return ResultOVUtil.error(-1,"login-error");
    }

}

package com.imooc.sell.controller;

import com.imooc.sell.OV.ResultOV;
import com.imooc.sell.utils.ResultOVUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 权限控制
 * @author: WangXue
 * @create: 2018-12-11 14:19
 */
@RestController
@RequestMapping(value = "/permission")
public class PermissionController {

    @PostMapping(value = "/login")
    public ResultOV login(String username, String password) {
        // 从SecurityUtils里边创建一个 subject
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        //主体提交认证
        subject.login(token);
        //根据权限，指定返回数据
        String role = "admin";
        if ("user".equals(role)) {
            return ResultOVUtil.success(subject.getSession().getId());
        }
        if ("admin".equals(role)) {
            return ResultOVUtil.success("欢迎来到管理员页面");
        }
        return ResultOVUtil.success("权限错误");
    }

}

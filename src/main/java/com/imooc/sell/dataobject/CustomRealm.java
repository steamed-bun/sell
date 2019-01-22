package com.imooc.sell.dataobject;

import com.imooc.sell.dataobject.usr.User;
import com.imooc.sell.service.usr.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 权限验证
 * @author: WangXue
 * @create: 2018-11-07 15:31
 */
@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 验证权限信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        String role = "admin";
        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }

    /**
     * 验证身份信息
     *
     * @param authenticationToken 用户身份信息token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
//        从数据库查出用户的信息
        User user = userService.findByUserName(userToken.getUsername());
        String password = user.getPassword();
        if (user == null) {

        }
        if (password == null) {
            System.out.println("用户名错误");
        } else if (!password.equals(new String(userToken.getPassword()))) {
            System.out.println("密码错误");
        }
        return new SimpleAuthenticationInfo(userToken.getPrincipal(), userToken.getCredentials(), getName());
    }
}

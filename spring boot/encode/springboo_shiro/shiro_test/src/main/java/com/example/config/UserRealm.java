package com.example.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

// 自定义
public class UserRealm extends AuthorizingRealm {

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");
        return null;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行=>认证doGetAuthenticationInfo");
        String name = "root";
        String password = "123456";
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        // 用户认证 密码认证只身做了
        if (!userToken.getUsername().equals(name))
            return null;
        return new SimpleAuthenticationInfo("",password,"");
    }
}

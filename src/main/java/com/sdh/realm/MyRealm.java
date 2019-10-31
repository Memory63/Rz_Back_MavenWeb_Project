package com.sdh.realm;

import com.sdh.pojo.SysUser;
import com.sdh.service.SysPermissionService;
import com.sdh.service.SysRoleService;
import com.sdh.service.SysUserService;
import lombok.Setter;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Set;

/**
 * @ClassName MyRealm
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 11:16
 * @Version 1.0
 */
@Setter
public class MyRealm extends AuthorizingRealm {

    private SysUserService sysUserService;
    private SysPermissionService sysPermissionService;
    private SysRoleService sysRoleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        Set<String> permission = sysPermissionService.queryPermissionByUsername(username);
        Set<String> role = sysRoleService.queryRoleByUsername(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(role);
        simpleAuthorizationInfo.setStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        SysUser sysUser = sysUserService.querySysUserByUsername(username);
        if (sysUser.getStatus()==0) {
            throw new LockedAccountException("禁止登陆");
        }
        if(sysUser ==null){
            return null;
        }
        return new SimpleAuthenticationInfo(
                sysUser.getUsername(), sysUser.getPassword(), ByteSource.Util.bytes("memory"),this.getName());
    }
}

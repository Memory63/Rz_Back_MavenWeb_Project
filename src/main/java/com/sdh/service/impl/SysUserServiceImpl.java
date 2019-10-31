package com.sdh.service.impl;

import com.sdh.dao.SysRoleDao;
import com.sdh.dao.SysUserDao;
import com.sdh.pojo.SysUser;
import com.sdh.pojo.SysUserRole;
import com.sdh.service.SysUserService;
import com.sdh.vo.UserRole;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName SysUserServiceimpl
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 11:04
 * @Version 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public SysUser querySysUserByUsername(String username) {
        return sysUserDao.querySysUserByUsername(username);
    }

    @Override
    public List<SysUser> querySysUserList(String rank, Integer pageNum, Integer pageSize) {
        return sysUserDao.querySysUserList(rank, pageNum, pageSize);
    }

    @Override
    public Integer getUserCount() {
        return sysUserDao.getUserCount();
    }

    @Override
    public Integer insertSysUser(UserRole userRole) {
        String password= new Sha256Hash(userRole.getPassword(), "memory", 1000).toBase64();
        userRole.setPassword(password);
        userRole.setCreateTime(new Date());
        userRole.setCreateUserId(7);
        userRole.setDeptId(1);
        userRole.setUserId(null);
        userRole.setLockDate(null);
        Integer userId= sysUserDao.insertSysUser(userRole);
        return userId;
    }

    @Override
    public void insertSysUserRole(Integer[] rolesId,Integer userId) {
        for (Integer rid: rolesId) {
            sysUserDao.insertSysUserRole(rid,userId);
        }
    }

    @Override
    public UserRole querySysUserById(Integer userId) {
        UserRole userRole = sysUserDao.querySysUserById(userId);
        List<SysUserRole> userRoles = sysRoleDao.querySysUserRoleByUserId(userId);
        Integer[] rolesArr = new Integer[userRoles.size()];
        int i = 0;
        for (SysUserRole role : userRoles) {
            rolesArr[i] = role.getRoleId();
            i++;
        }
        userRole.setRoles(rolesArr);
        return userRole;
    }

    @Override
    public void updateSysUserById(UserRole userRole) {
        //删除改用户下所有的角色
        sysRoleDao.deleteSysUserRole(userRole.getUserId());
        //再进行添加用户修改的角色
        for (Integer role : userRole.getRoles()) {
            sysRoleDao.insertSysUserRole(userRole.getUserId(),role);
        }
    }

    @Override
    public void deleteSysUserService(Integer userId) {
        sysUserDao.deleteSysUserService(userId);
        sysRoleDao.deleteSysUserRole(userId);
    }

    @Override
    public List<SysUser> querySysUsers() {
        return sysUserDao.querySysUsers();
    }

    @Override
    public void unlockUser(Integer userId) {
        sysUserDao.unlockUser(userId);
    }


}

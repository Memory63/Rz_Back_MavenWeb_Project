package com.sdh.service;

import com.sdh.pojo.SysUser;
import com.sdh.vo.UserRole;

import java.util.List;

/**
 * @ClassName SysUserService
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 11:04
 * @Version 1.0
 */
public interface SysUserService {
    SysUser querySysUserByUsername(String username);

    List<SysUser> querySysUserList(String rank, Integer pageNum, Integer pageSize);

    Integer getUserCount();

    Integer insertSysUser(UserRole userRole);

    void insertSysUserRole(Integer[] roles,Integer userId);

    UserRole querySysUserById(Integer userId);

    void updateSysUserById(UserRole userRole);

    void deleteSysUserService(Integer userId);

    List<SysUser> querySysUsers();

    void unlockUser(Integer userId);
}

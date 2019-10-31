package com.sdh.dao;

import com.sdh.pojo.SysUser;
import com.sdh.vo.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName SysUserDao
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 10:50
 * @Version 1.0
 */
public interface SysUserDao {
    /**
     * todo: 通过用户名获取该用户信息
     * @param username
     * @return
     */
    SysUser querySysUserByUsername(@Param("username") String username);

    Integer insertSysUser(UserRole userRole);

    List<SysUser> querySysUserList(@Param("rank")String rank, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    Integer getUserCount();

    void insertSysUserRole(@Param("rolesId") Integer rolesId,@Param("userId") Integer userId);

    UserRole querySysUserById(@Param("userId") Integer userId);

    void updateSysUserById(UserRole userRole);

    void deleteSysUserService(@Param("userId") Integer userId);

    List<SysUser> querySysUsers();

    void unlockUser(@Param("userId") Integer userId);
}

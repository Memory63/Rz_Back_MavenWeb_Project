package com.sdh.service;

import com.sdh.pojo.SysRole;
import com.sdh.pojo.SysRoleMenu;
import com.sdh.pojo.SysUserRole;
import com.sdh.vo.RoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @ClassName SysMenuService
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 17:52
 * @Version 1.0
 */
public interface SysRoleService {
    Set<String> queryRoleByUsername(@Param("username") String username);

    List<SysRole> querySysRoleList();

    List<SysUserRole> querySysUserRoleByUserId(@Param("userId") Integer userId);

    void deleteSysUserRole(@Param("userId") Integer userId);

    void insertSysUserRole(@Param("userId")Integer userId,@Param("roleId") Integer roleId);

    Integer getSysRoleCount();

    List<SysRole> querySysRolePage(@Param("order") String order,@Param("limit") Integer limit,@Param("offset") Integer offset);

    Integer insertSysRole(RoleInfo roleInfo);

    void insertMenuIdAndRoleId(@Param("menuId") Integer menuId,@Param("roleId") Integer roleId);

    RoleInfo querySysRoleByRoleId(@Param("roleId") Integer roleId);

    List<SysRoleMenu> querySysUserRoleByRoleId(@Param("roleId") Integer roleId);

    void updateSysRoleInfo(RoleInfo roleInfo);

    void deleteSysUserRoleByRoleId(@Param("roleId") Integer roleId);

    void deleteSysRoleByRoleId(Integer roleId);
}

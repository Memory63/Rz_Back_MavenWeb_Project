package com.sdh.service.impl;

import com.sdh.dao.SysRoleDao;
import com.sdh.pojo.SysRole;
import com.sdh.pojo.SysRoleMenu;
import com.sdh.pojo.SysUserRole;
import com.sdh.service.SysRoleService;
import com.sdh.vo.RoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @ClassName SysPermissionServiceImpl
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 22:31
 * @Version 1.0
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public Set<String> queryRoleByUsername(String username) {
        return sysRoleDao.queryRoleByUsername(username);
    }

    @Override
    public List<SysRole> querySysRoleList() {
        return sysRoleDao.querySysRoleList();
    }

    @Override
    public List<SysUserRole> querySysUserRoleByUserId(Integer userId) {
        return sysRoleDao.querySysUserRoleByUserId(userId);
    }

    @Override
    public void deleteSysUserRole(Integer userId) {
        sysRoleDao.deleteSysUserRole(userId);
    }

    @Override
    public void insertSysUserRole(Integer userId, Integer roleId) {
        sysRoleDao.insertSysUserRole(userId,roleId);
    }

    @Override
    public Integer getSysRoleCount() {
        return sysRoleDao.getSysRoleCount();
    }

    @Override
    public List<SysRole> querySysRolePage(String order, Integer limit, Integer offset) {
        return sysRoleDao.querySysRolePage(order,limit,offset);
    }

    @Override
    public Integer insertSysRole(RoleInfo roleInfo) {
        roleInfo.setCreateTime(new Date());
        roleInfo.setRoleId(null);
        roleInfo.setCreateUserId(7);
        return sysRoleDao.insertSysRole(roleInfo);
    }

    @Override
    public void insertMenuIdAndRoleId(Integer menuId, Integer roleId) {
        sysRoleDao.insertMenuIdAndRoleId(menuId,roleId);
    }

    @Override
    public RoleInfo querySysRoleByRoleId(Integer roleId) {
        RoleInfo roleInfo = sysRoleDao.querySysRoleByRoleId(roleId);
        List<SysRoleMenu> roleMenus = sysRoleDao.querySysUserRoleByRoleId(roleId);
        Integer[] menu = new Integer[roleMenus.size()];
        int i = 0;
        for (SysRoleMenu roleMenu : roleMenus) {
            menu[i] = roleMenu.getMenuId();
            i++;
        }
        roleInfo.setMenus(menu);
        return roleInfo;
    }

    @Override
    public List<SysRoleMenu> querySysUserRoleByRoleId(Integer roleId) {
        return sysRoleDao.querySysUserRoleByRoleId(roleId);
    }

    @Override
    public void updateSysRoleInfo(RoleInfo roleInfo) {
        //修改该角色的信息
        sysRoleDao.updateSysRoleInfo(roleInfo);

        //删除该角色的所有权限
        sysRoleDao.deleteSysUserRoleByRoleId(roleInfo.getRoleId());
        //添加该角色的权限
        for (Integer menu : roleInfo.getMenus()) {
            sysRoleDao.insertMenuIdAndRoleId(menu,roleInfo.getRoleId());
        }
    }

    @Override
    public void deleteSysUserRoleByRoleId(Integer roleId) {
        sysRoleDao.deleteSysUserRoleByRoleId(roleId);
    }

    @Override
    public void deleteSysRoleByRoleId(Integer roleId) {
        sysRoleDao.deleteSysRoleByRoleId(roleId);
    }

}

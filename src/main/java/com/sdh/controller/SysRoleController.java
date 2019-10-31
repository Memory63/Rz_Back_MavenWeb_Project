package com.sdh.controller;

import com.sdh.pojo.SysRole;
import com.sdh.service.SysRoleService;
import com.sdh.utils.R;
import com.sdh.vo.RoleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName SysRoleControler
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/30 9:24
 * @Version 1.0
 */
@Controller
@RequestMapping("/sys")
@CrossOrigin("http://localhost:8080")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;


    /**
     * todo: 查询角色信息
     * @return
     */
    @RequestMapping("/roles")
    @ResponseBody
    public R querySysRole(){
        List<SysRole> roleList =  sysRoleService.querySysRoleList();
        return R.ok().put("roles",roleList);
    }

    @RequestMapping("/role/list")
    @ResponseBody
    public R querySysRoleList(String order,Integer limit,Integer offset){
        Integer total = sysRoleService.getSysRoleCount();
        List<SysRole> roleList = sysRoleService.querySysRolePage(order,limit,offset);
        return R.ok().put("total",total).put("rows",roleList);
    }

    /**
     * todo: 添加角色，并回填角色id，再添加到sys_menu_role
     * @param roleInfo
     * @return
     */
    @RequestMapping("/role/save")
    @ResponseBody
    public R insertSysRole(@RequestBody RoleInfo roleInfo){
        System.out.println(roleInfo);
        Integer roleId = sysRoleService.insertSysRole(roleInfo);
        for (Integer menuId : roleInfo.getMenus()) {
            sysRoleService.insertMenuIdAndRoleId(menuId,roleInfo.getRoleId());
        }
        return new R(0);
    }

    /**
     * todo：修改功能，先获取该角色的信息
     * @param roleId
     * @return
     */
    @RequestMapping("/role/info/{roleId}")
    @ResponseBody
    public R updateShowSysRoleInfo(@PathVariable Integer roleId){
        RoleInfo roleInfo = sysRoleService.querySysRoleByRoleId(roleId);
        return R.ok().put("role",roleInfo);
    }

    /**
     * todo: 获取前端信息，修改角色信息
     * @param roleInfo
     * @return
     */
    @RequestMapping("/role/update")
    @ResponseBody
    public R updateSysRoleInfo(@RequestBody RoleInfo roleInfo){
        System.out.println("角色信息"+roleInfo);
        sysRoleService.updateSysRoleInfo(roleInfo);
        return new R(0);
    }

    @DeleteMapping("/role/del/{roleId}")
    @ResponseBody
    public R deleteSysRole(@PathVariable Integer roleId){
        System.out.println(roleId);
        sysRoleService.deleteSysUserRoleByRoleId(roleId);
        sysRoleService.deleteSysRoleByRoleId(roleId);
        return new R(0);
    }
}

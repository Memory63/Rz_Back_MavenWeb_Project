package com.sdh.controller;

import com.sdh.pojo.SysMenu;
import com.sdh.service.SysMenuService;
import com.sdh.service.SysPermissionService;
import com.sdh.utils.R;
import com.sdh.vo.UserMenu;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName SysMenuController
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 19:01
 * @Version 1.0
 */
@Controller
@RequestMapping("/sys/menu")
@CrossOrigin(value = "http://localhost:8080")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysPermissionService sysPermissionService;

    @RequestMapping("/user")
    @ResponseBody
    public R queryMenu(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        List<UserMenu> menuList = sysMenuService.querySysMenuByUsername(username, 0);
        Set<String> permission = sysPermissionService.queryPermissionByUsername(username);
        Set<String> per = new HashSet<>();
        for (String perm : permission) {
            if(perm!=null){
                String[] str = perm.split(",");
                for (String s : str) {
                    per.add(s);
                }
            }
        }
        return R.ok().put("menuList",menuList).put("permissions",per);
    }

    /**
     * todo：更新或修改角色是，需要获取菜单列表
     * @return
     */
    @RequestMapping("/select")
    @ResponseBody
    public R queryRoleMenu(){
        List<SysMenu> menuList = sysMenuService.querySysMenuList();
        return R.ok().put("menuList",menuList);
    }

    @RequestMapping("list")
    @ResponseBody
    public R queryMenuPage(String order,Integer limit,Integer offset){
        Integer total = sysMenuService.getMenuCount();
        List<SysMenu> rows = sysMenuService.querySysMenuPage(order,limit,offset);
        return R.ok().put("total",total).put("rows",rows);
    }

}

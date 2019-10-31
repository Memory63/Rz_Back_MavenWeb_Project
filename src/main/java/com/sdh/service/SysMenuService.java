package com.sdh.service;

import com.sdh.pojo.SysMenu;
import com.sdh.vo.UserMenu;

import java.util.List;

/**
 * @ClassName SysMenuService
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 17:52
 * @Version 1.0
 */
public interface SysMenuService {
    List<UserMenu> querySysMenuByUsername(String username, Integer id);

    List<SysMenu> querySysMenuList();

    Integer getMenuCount();

    List<SysMenu> querySysMenuPage(String order, Integer limit, Integer offset);
}

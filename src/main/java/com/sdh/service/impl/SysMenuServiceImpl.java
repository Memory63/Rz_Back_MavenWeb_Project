package com.sdh.service.impl;

import com.sdh.dao.SysMenuDao;
import com.sdh.pojo.SysMenu;
import com.sdh.service.SysMenuService;
import com.sdh.vo.UserMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysMenuServiceImpl
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 17:53
 * @Version 1.0
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public List<UserMenu> querySysMenuByUsername(String username,Integer id) {
        List<UserMenu> menuList = sysMenuDao.querySysMenuByUsername(username, id);

        for (UserMenu menu : menuList) {
            menu.setList(sysMenuDao.querySysMenuByUsername(username, menu.getMenuId()));

        }
        return menuList;
    }

    @Override
    public List<SysMenu> querySysMenuList() {
        return sysMenuDao.querySysMenuList();
    }

    @Override
    public Integer getMenuCount() {
        return sysMenuDao.getMenuCount();
    }

    @Override
    public List<SysMenu> querySysMenuPage(String order, Integer limit, Integer offset) {
        return sysMenuDao.querySysMenuPage(order,limit,offset);
    }
}

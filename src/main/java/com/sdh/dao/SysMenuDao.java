package com.sdh.dao;

import com.sdh.pojo.SysMenu;
import com.sdh.vo.UserMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName SysMenuDao
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 17:48
 * @Version 1.0
 */
public interface SysMenuDao {
    List<UserMenu> querySysMenuByUsername(@Param("username") String username, @Param("id") Integer id);

    List<SysMenu> querySysMenuList();

    Integer getMenuCount();

    List<SysMenu> querySysMenuPage(@Param("order") String order, @Param("limit") Integer limit, @Param("offset") Integer offset);

    List<UserMenu> querySysMenuByUsernameAndType(@Param("type") Integer type,@Param("username")String username);
}

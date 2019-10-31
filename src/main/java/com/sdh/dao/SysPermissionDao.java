package com.sdh.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @ClassName SysPermissionDao
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 22:27
 * @Version 1.0
 */
public interface SysPermissionDao {
    Set<String> queryPermissionByUsername(@Param("username") String username);
}

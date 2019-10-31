package com.sdh.service;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @ClassName SysPermissionService
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 22:31
 * @Version 1.0
 */
public interface SysPermissionService {
    Set<String> queryPermissionByUsername(@Param("username") String username);
}

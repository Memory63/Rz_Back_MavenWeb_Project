package com.sdh.service.impl;

import com.sdh.dao.SysPermissionDao;
import com.sdh.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ClassName SysPermissionServiceImpl
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 22:31
 * @Version 1.0
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public Set<String> queryPermissionByUsername(String username) {
        return sysPermissionDao.queryPermissionByUsername(username);
    }
}

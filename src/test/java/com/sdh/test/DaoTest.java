package com.sdh.test;

import com.sdh.dao.SysUserDao;
import com.sdh.pojo.SysUser;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName DaoTest
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 15:10
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DaoTest {
    @Autowired
    private SysUserDao sysUserDao;

    @Test
    public void testInsertUser(){
        SysUser sysUser = new SysUser();
        sysUser.setUsername("sdh");
        String salt = "memory";
        String password = new Sha256Hash("123", salt, 1000).toBase64();
        sysUser.setPassword(password);
//        sysUserDao.insertSysUser(sysUser);
    }
}

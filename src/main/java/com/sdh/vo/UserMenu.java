package com.sdh.vo;

import com.sdh.pojo.SysMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserMenu
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 17:55
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMenu extends SysMenu{
    private List<UserMenu> list=new ArrayList();
}

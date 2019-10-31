package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName SysRoleMenu
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 16:49
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleMenu {
    private Integer id;
    private Integer roleId;
    private Integer menuId;
}

package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName SysMenu
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 16:39
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenu {
    private Integer menuId;
    private Integer parentId;
    private String name;
    private String url;
    private String perms;
    private Integer type;
    private String icon;
    private Integer orderNum;
}

package com.sdh.vo;

import com.sdh.pojo.SysRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName RoleInfo
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/30 17:20
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleInfo extends SysRole {
    Integer[] menus;
}

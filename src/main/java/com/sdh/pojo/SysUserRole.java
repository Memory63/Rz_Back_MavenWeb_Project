package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName SysUserRole
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 16:51
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserRole {
    private Integer id;
    private Integer userId;
    private Integer roleId;
}

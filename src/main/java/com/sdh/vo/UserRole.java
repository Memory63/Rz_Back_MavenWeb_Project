package com.sdh.vo;

import com.sdh.pojo.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserRole
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/30 10:04
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole extends SysUser {
    private Integer[] roles;
}

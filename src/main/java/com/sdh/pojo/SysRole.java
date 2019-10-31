package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName SysRole
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 16:39
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRole {
    private Integer roleId;
    private String roleName;
    private String remark;
    private Integer createUserId;
    private Date createTime;
}

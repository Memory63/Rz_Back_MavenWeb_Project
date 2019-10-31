package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName SysUesr
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 10:43
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private String mobile;
    private Integer status;
    private Integer createUserId;
    private Date createTime;
    private Integer deptId;
    private String sex;
    private Date lockDate;
}

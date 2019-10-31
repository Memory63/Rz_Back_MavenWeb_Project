package com.sdh.vo;

import com.sdh.pojo.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName UserLongin
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 14:41
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin extends SysUser {
    private String captcha;
    private Boolean rememberMe;
}

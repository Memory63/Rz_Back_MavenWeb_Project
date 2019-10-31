package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName SysConfig
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 16:55
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysConfig {
    private Integer id;
    private String key;
    private String value;
    private Integer status;
    private String remark;
}

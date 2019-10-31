package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName SysLog
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 16:53
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysLog {
    private Integer id;
    private String username;
    private String operation;
    private String method;
    private String params;
    private String ip;
    private Date createDate;
}

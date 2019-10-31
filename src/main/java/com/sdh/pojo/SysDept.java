package com.sdh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName SysDept
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/29 16:56
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysDept {
    private Integer id;
    private String deptName;
}

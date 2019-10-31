package com.sdh.pojo;

import lombok.Data;

/**
 * @ClassName JobAndTrigger
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/31 14:48
 * @Version 1.0
 */
@Data
public class JobAndTrigger {
    private String jobName;
    private String jobGroup;
    private String jobClassName;
    private String triggerName;
    private String triggerGroup;
    private String cronExpression;
    private String timeZoneId;
}

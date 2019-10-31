package com.sdh.service;

import com.sdh.pojo.JobAndTrigger;

import java.util.List;

/**
 * @ClassName JobDAO
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/31 15:21
 * @Version 1.0
 */
public interface JobService {
    List<JobAndTrigger> queryJobs();
}

package com.sdh.service.impl;

import com.sdh.dao.JobDAO;
import com.sdh.pojo.JobAndTrigger;
import com.sdh.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName JobServerImpl
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/31 15:22
 * @Version 1.0
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDAO jobDAO;

    @Override
    public List<JobAndTrigger> queryJobs() {
        return jobDAO.queryJobs();
    }
}

package com.sdh.controller;

import com.sdh.pojo.JobAndTrigger;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/31 14:55
 * @Version 1.0
 */
@Controller
@RequestMapping("/quartz")
public class TestController {

    @Autowired
    private Scheduler scheduler;

    // 添加一个定时任务
    // 方法的参数：jt=新任务的相关数据
    @RequestMapping("add")
    public String addJob(JobAndTrigger jt) throws ClassNotFoundException, SchedulerException {
        // 创建JobDetail
        JobDetail jobDetail=null;
        jobDetail = JobBuilder.newJob((Class<? extends Job>)Class.forName(jt.getJobClassName()))
                .withIdentity(jt.getJobName(), jt.getJobGroup()).storeDurably(true).build();
        CronTrigger cronTrigger = null;
        cronTrigger = TriggerBuilder.newTrigger().withIdentity(jt.getJobName(),jt.getJobGroup())
                .withSchedule(CronScheduleBuilder.cronSchedule(jt.getCronExpression()))
                .build();
        scheduler.scheduleJob(jobDetail,cronTrigger);
        //scheduler.start();
        return "index";
    }


}

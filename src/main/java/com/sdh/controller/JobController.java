package com.sdh.controller;

import com.sdh.pojo.JobAndTrigger;
import com.sdh.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName JobController
 * @Description TODO
 * @Author SDH
 * @CreateDate 2019/10/31 15:25
 * @Version 1.0
 */
@Controller
@RequestMapping("Job")
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping("seeJob")
    public String queryJobs(Model model){
        List<JobAndTrigger> jobAndTriggers = jobService.queryJobs();
        model.addAttribute("jobs",jobAndTriggers);
        return "jobList";
    }
}

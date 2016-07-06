package com.haigou.controller;

import com.haigou.service.ScheduleJobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by user on 2016/7/6.
 */
@Controller
@RequestMapping("/job")
public class ScheduleJobController {
    /** job service */
    @Resource(name="scheduleJobService")
    private ScheduleJobService scheduleJobService;

    @RequestMapping(value = "index.xhtml",method = RequestMethod.GET)
    public String index(ModelMap model){
        return "job/index.vm";
    }

    @RequestMapping(value = "jobList.xhtml",method = RequestMethod.GET)
    @ResponseBody
    public Object jobList(ModelMap model){
        return scheduleJobService.listJob();
    }
}

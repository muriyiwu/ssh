package com.haigou.controller;

import com.haigou.service.ScheduleJobService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

    static Logger logger = LogManager.getLogger(ScheduleJobController.class);
    /** job service */
    @Resource(name="scheduleJobService")
    private ScheduleJobService scheduleJobService;

    @RequestMapping(value = "index.xhtml",method = RequestMethod.GET)
    public String index(ModelMap model){
        return "job/index.vm";
    }

    @RequestMapping(value = "testThrowsRuntimeExceptionTransaction.xhtml",method = RequestMethod.GET)
    @ResponseBody
    public Object testThrowsRuntimeExceptionTransaction(ModelMap model){
        logger.warn("testThrowsRuntimeExceptionTransaction.xhtml");
        try{
            scheduleJobService.testThrowsRuntimeExceptionTransaction();
        } catch (Exception e){
            logger.error("runtime 异常抛出",e);
        }
        return "runtime 异常抛出，事务启用";
    }

    @RequestMapping(value = "testCatchRuntimeExceptionTransaction.xhtml",method = RequestMethod.GET)
    @ResponseBody
    public Object testCatchRuntimeExceptionTransaction(ModelMap model){
        logger.warn("testCatchRuntimeExceptionTransaction.xhtml");
        scheduleJobService.testCatchRuntimeExceptionTransaction();
        return "runtime 异常被捕获，事务未启用";
    }

    @RequestMapping(value = "testThrowsExceptionTransaction.xhtml",method = RequestMethod.GET)
    @ResponseBody
    public Object testThrowsExceptionTransaction(ModelMap model){
        logger.warn("testThrowsExceptionTransaction.xhtml");
        try {
            scheduleJobService.testThrowsExceptionTransaction();
        } catch (Exception e) {
            logger.error(e);
        }
        return "未捕获普通异常，事务未启用";
    }

    @RequestMapping(value = "jobList.xhtml",method = RequestMethod.GET)
    @ResponseBody
    public Object jobList(ModelMap model){
        return scheduleJobService.listJob();
    }
}

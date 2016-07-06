package com.haigou.service.impl;

import com.alibaba.fastjson.JSON;
import com.haigou.dao.ScheduleJobDao;
import com.haigou.model.ScheduleJob;
import com.haigou.service.ScheduleJobService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 2016/7/6.
 */
@Service("scheduleJobService")
public class ScheduleJobServiceImpl implements ScheduleJobService{
    static Logger logger = LogManager.getLogger(ScheduleJobServiceImpl.class);
    @Autowired
    private ScheduleJobDao scheduleJobDao;
    public List<ScheduleJob> listJob() {
        List<ScheduleJob> jobs = scheduleJobDao.queryList();
        logger.warn(JSON.toJSONString(jobs));
        return jobs;
    }
}

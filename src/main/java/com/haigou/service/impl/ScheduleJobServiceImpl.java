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

    public void testThrowsRuntimeExceptionTransaction() {
        scheduleJobDao.updateStatus(65L,"ONLINE");
        List<ScheduleJob> jobs = scheduleJobDao.queryList();
        logger.warn(JSON.toJSONString(jobs));
        throw new RuntimeException("测试事务管理");
    }

    public void testCatchRuntimeExceptionTransaction() {
        try{
            scheduleJobDao.updateStatus(65L,"ONLINE");
            List<ScheduleJob> jobs = scheduleJobDao.queryList();
            logger.warn(JSON.toJSONString(jobs));
            throw new RuntimeException("测试事务管理");
        } catch (Exception e){
            logger.error("事务异常捕获",e);
        }

    }

    public void testThrowsExceptionTransaction() throws Exception {
        scheduleJobDao.updateStatus(65L,"OFFLINE");
        List<ScheduleJob> jobs = scheduleJobDao.queryList();
        logger.warn(JSON.toJSONString(jobs));
        throw new Exception("测试事务管理");
    }
}

package com.haigou.dao;

import com.haigou.model.ScheduleJob;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by user on 2016/7/6.
 */
public interface ScheduleJobDao {
    List<ScheduleJob> queryList();
    Long insert(ScheduleJob scheduleJob);
    void deleteById(Long scheduleJobId);
    void updateStatus(@Param("scheduleJobId")Long scheduleJobId, @Param("status")String status);
}

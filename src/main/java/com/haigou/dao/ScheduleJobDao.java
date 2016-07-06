package com.haigou.dao;

import com.haigou.model.ScheduleJob;

import java.util.List;

/**
 * Created by user on 2016/7/6.
 */
public interface ScheduleJobDao {
    List<ScheduleJob> queryList();
}

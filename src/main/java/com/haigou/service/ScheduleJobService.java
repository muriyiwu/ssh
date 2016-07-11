package com.haigou.service;

import com.haigou.model.ScheduleJob;

import java.util.List;

/**
 * Created by user on 2016/7/6.
 */
public interface ScheduleJobService {
    public abstract List<ScheduleJob> listJob();
    public abstract void testThrowsRuntimeExceptionTransaction();
    public abstract void testCatchRuntimeExceptionTransaction();
    public abstract void testThrowsExceptionTransaction() throws Exception;
}

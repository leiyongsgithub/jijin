package com.test.spring.boot.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import com.alibaba.fastjson.JSONObject;

public class SimpleJob2 implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobKey jobKey = context.getJobDetail().getKey();
		System.out.println("----------1--------"+JSONObject.toJSONString(jobKey));
	}

}

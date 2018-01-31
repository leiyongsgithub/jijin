package com.test.spring.boot.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import com.alibaba.fastjson.JSONObject;

public class SimpleJob implements Job{

	@Override
	public void execute(JobExecutionContext context)  {
		JobKey jobKey = context.getJobDetail().getKey();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------0--------"+JSONObject.toJSONString(jobKey));
	}

}

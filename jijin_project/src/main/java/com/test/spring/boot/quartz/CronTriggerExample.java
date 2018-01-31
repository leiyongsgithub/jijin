package com.test.spring.boot.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerExample {
	
	public static void main(String[] args) throws Exception {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		
		JobDetail job = JobBuilder.newJob(SimpleJob.class)
			    .withIdentity("job0", "group0")
			    .build();

			CronTrigger trigger = TriggerBuilder.newTrigger()
			    .withIdentity("trigger0", "group0")
			    .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
			    .build();
			
			JobDetail job1 = JobBuilder.newJob(SimpleJob2.class)
					.withIdentity("job1", "group1")
					.build();
			
			CronTrigger trigger1 = TriggerBuilder.newTrigger()
					.withIdentity("trigger1", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
					.build();
			
			sched.scheduleJob(job, trigger);
			sched.scheduleJob(job1, trigger1);
			sched.start();
			Thread.sleep(100000);
			sched.shutdown();
	}
}

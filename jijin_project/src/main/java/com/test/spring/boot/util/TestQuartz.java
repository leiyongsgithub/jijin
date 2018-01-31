package com.test.spring.boot.util;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class TestQuartz {

	public static void main(String[] args) {
		test();
	}
	
	private static void test(){
		try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // and start it off
            scheduler.start();

            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
	}
}

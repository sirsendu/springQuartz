package com.sirsendu.quartz;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class TestJob extends QuartzJobBean {
	private static int count;

	@Override
	protected void executeInternal(JobExecutionContext jobContext)
			throws JobExecutionException {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("TestJob start: " + jobContext.getFireTime());
		JobDetail jobDetail = jobContext.getJobDetail();
		TestJobHelper jobHelper = (TestJobHelper) jobDetail.getJobDataMap().get("jobState");
		System.out.println("Example name is: " + jobHelper.getSomeStr());		
		System.out.println("TestJob end: " + jobContext.getJobRunTime() + ", key: " + jobDetail.getKey());
		System.out.println("TestJob next scheduled time: " + jobContext.getNextFireTime());
		System.out.println("--------------------------------------------------------------------");
		
		count++;
		System.out.println("Job count " + count);
		
		JobLatch latch = (JobLatch) jobDetail.getJobDataMap().get("jobLatch");
		if (latch != null) {
			latch.countDown();
			System.out.println("Job executed, release latch");
		}
	}

}

package com.sirsendu.quartz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringQuartzMethodInvocationMain {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"springQuartzMethodInvocationContext.xml");
		try {
			Thread.sleep(3000);
		} finally {
			context.close();
		}
	}
}

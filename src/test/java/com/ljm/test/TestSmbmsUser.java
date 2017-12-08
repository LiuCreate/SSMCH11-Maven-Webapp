package com.ljm.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ljm.service.SmbmsUserService;

public class TestSmbmsUser {
	ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
	SmbmsUserService userService = (SmbmsUserService) app.getBean("smbmsUserServiceImpl");

	@Test
	public void addSmbmsUser() {
		
	}

}

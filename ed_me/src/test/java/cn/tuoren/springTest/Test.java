package cn.tuoren.springTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class Test {
	@org.junit.Test
	public void testSpring() {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		TestUserService testUserService = ac.getBean(TestUserService.class);
		testUserService.service();
		
	}
	
	@org.junit.Test
	public void testSpring2() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService2 userService2 = (UserService2)ctx.getBean("userService2");
        userService2.add();
        
	}
}
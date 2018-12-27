package cn.tuoren.ed.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.tuoren.ed.base.BaseServiceImpl;
import cn.tuoren.ed.domain.Department;
import cn.tuoren.ed.service.DepartmentService;

public class BaseServiceImplTest {
	private ApplicationContext ac=new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
	
	@Test
	public void testService() {
		@SuppressWarnings("rawtypes")
		BaseServiceImpl departmentService=(BaseServiceImpl)ac.getBean("departmentService");
		System.out.println(departmentService.getClass());
	}
	@Test
	public void testGetById() {
		BaseServiceImpl<Department> departmentService=(DepartmentService)ac.getBean("departmentService");
		Department department=departmentService.getById(new Long(2));
		System.out.println(department.getDepartmentName());
	}
	
	
	
	
}

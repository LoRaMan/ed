package cn.tuoren.ed.test;

import java.util.List;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.tuoren.ed.dao.impl.DepartmentDao;
import cn.tuoren.ed.domain.Department;


public class BaseDaoImplTest {
	
	private ApplicationContext ac=new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");

	@Test
	public void testGetById() {
		DepartmentDao departmentDao=(DepartmentDao)ac.getBean("departmentDao");
		System.out.println(departmentDao.getById(new Long(2)).getDepartmentName());
	}
	
	@Test
	public void testSave() {
		DepartmentDao departmentDao=(DepartmentDao)ac.getBean("departmentDao");
		System.out.println(departmentDao.getClass());
		departmentDao.save(new Department());
		System.out.println("save complete....");
	}
	
	@Test
	public void testUpdate() {
		DepartmentDao departmentDao=(DepartmentDao)ac.getBean("departmentDao");
		List<Department> list=departmentDao.getAll();
		if (list.isEmpty()) {
			System.out.println("没有记录...");
			return;
		}
		Department department=list.get(0);
		department.setDepartmentName("me2");
		department.setRemarks("test2");
		departmentDao.update(department);
	}
	
	
	
	@Test
	public void testGetAll() {
		DepartmentDao departmentDao=(DepartmentDao)ac.getBean("departmentDao");
		List<Department> list=departmentDao.getAll();
		if (list.isEmpty()) {
			System.out.println("没有记录...");
			return;
		}
		for (Department department : list) {
			System.out.println(department.getDepartmentName());
		}
	}
	@Test
	public void testDelete() {
		DepartmentDao departmentDao=(DepartmentDao)ac.getBean("departmentDao");
		List<Department> list=departmentDao.getAll();
		if (list.isEmpty()) {
			System.out.println("没有记录...");
			return;
		}
		departmentDao.delete(list.get(0).getDepartmentId());
		System.out.println("删除成功...");
	}
}

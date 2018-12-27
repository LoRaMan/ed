package cn.tuoren.springTest;

import org.springframework.beans.factory.annotation.Autowired;

public class TestBaseService<T> {
	@Autowired
	private TestBaseDao<T> testBaseDao;
	public void service() {
        System.out.println(testBaseDao);
        testBaseDao.say();
    }
	
}

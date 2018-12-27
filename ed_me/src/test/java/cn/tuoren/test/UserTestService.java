package cn.tuoren.test;


import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserTestService {
	@Resource
	private SessionFactory sessionFactory;
	@Transactional
	public void saveTwoUsers() {
		Session session=sessionFactory.getCurrentSession();

		session.save(new UserTest());
		session.save(new UserTest());
	}
}



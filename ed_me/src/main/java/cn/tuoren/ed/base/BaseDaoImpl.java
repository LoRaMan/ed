package cn.tuoren.ed.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cn.tuoren.ed.config.Configuration;
import cn.tuoren.ed.util.HqlHelper;
/**
 * 
 * @author wangqing 
 * @version 1.0.0  2018-12-4
 * @param <T>
 */

@Transactional
@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements IBase<T> {
	//这里的sessionFactory由Spring进行注入
	@Autowired
	private SessionFactory sessonfacory;
	protected Class<T> clazz;
	
	public BaseDaoImpl() {
		// 通过反射得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) pt.getActualTypeArguments()[0];

		System.out.println("clazz = " + clazz.getName());
	}
	//获取SessionFactory对象
	public SessionFactory getSessonfacory() {
		return sessonfacory;
	}
	//依赖注入，需要setter方法
	public void setSessonfacory(SessionFactory sessonfacory) {
		this.sessonfacory = sessonfacory;
	}
	//获取Session对象
	protected Session getSession() {
		return sessonfacory.getCurrentSession();
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void delete(Long id) {
		Object object=this.getSession().get(clazz, id);
		getSession().delete(object);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public T getById(Long id) {
		if (id==null) {
			return null;
		}
		return getSession().get(clazz, id);
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		if (ids==null || ids.length==0) {
			return Collections.EMPTY_LIST;
		}
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)")//
				.setParameterList("ids", ids)//
				.list();
	}

	@Override
	public List<T> getAll() {
		return getSession().createQuery("FROM "+clazz.getSimpleName()).list();
	}
	
	@Override
	public PageBean<T> getPageBean(int currentPageCode, String queryListHQL, Object[] parameters) {
		int pageSize = Configuration.pageSize;

		// 查询本页的数据列表
		Query listQuery = getSession().createQuery(queryListHQL);
		if (parameters != null && parameters.length > 0) { // 设置参数
			for (int i = 0; i < parameters.length; i++) {
				listQuery.setParameter(i, parameters[i]);
			}
		}
		listQuery.setFirstResult((currentPageCode - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List<T> list = listQuery.list(); // 执行查询

		// 查询总记录数
		Query countQuery = getSession().createQuery("SELECT COUNT(*) " + queryListHQL);
		if (parameters != null && parameters.length > 0) { // 设置参数
			for (int i = 0; i < parameters.length; i++) {
				countQuery.setParameter(i, parameters[i]);
			}
		}
		Long count = (Long) countQuery.uniqueResult(); // 执行查询

		//return new PageBean(currentPageCode, pageSize, list, count.intValue());
		return new PageBean<>(pageSize, currentPageCode, count.intValue(), list);
	}
	
	
	// 最终版
	@Override
	public PageBean<T> getPageBean(int currentPageCode, HqlHelper hqlHelper) {
		int pageSize = Configuration.pageSize;
		List<Object> parameters = hqlHelper.getParameters();

		// 查询本页的数据列表
		Query listQuery = getSession().createQuery(hqlHelper.getQueryListHql());
		if (parameters != null && parameters.size() > 0) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		}
		listQuery.setFirstResult((currentPageCode - 1) * pageSize);
		listQuery.setMaxResults(pageSize);
		List<T> list = listQuery.list(); // 执行查询

		// 查询总记录数
		Query countQuery = getSession().createQuery(hqlHelper.getQueryCountHql());
		if (parameters != null && parameters.size() > 0) { // 设置参数
			for (int i = 0; i < parameters.size(); i++) {
				countQuery.setParameter(i, parameters.get(i));
			}
		}
		Long count = (Long) countQuery.uniqueResult(); // 执行查询
		
		return new PageBean<T>(pageSize, currentPageCode, count.intValue(), list);
	}
	
}

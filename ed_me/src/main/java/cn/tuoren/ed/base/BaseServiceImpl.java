package cn.tuoren.ed.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.tuoren.ed.util.HqlHelper;

public class BaseServiceImpl<T> {
	@Autowired
	protected BaseDaoImpl<T> baseDaoImpl;

	public void save(T entity) {
		baseDaoImpl.save(entity);
	}

	public void delete(Long id) {
		baseDaoImpl.delete(id);
	}

	public void update(T entity) {
		baseDaoImpl.update(entity);
	}

	public T getById(Long id) {
		return baseDaoImpl.getById(id);
	}

	public List<T> getByIds(Long[] ids) {
		return baseDaoImpl.getByIds(ids);
	}

	public List<T> getAll() {
		return baseDaoImpl.getAll();
	}

	public PageBean<T> getPageBean(int currentPageCode, String queryListHQL, Object[] params) {
		return baseDaoImpl.getPageBean(currentPageCode, queryListHQL, params);
	}

	public PageBean<T> getPageBean(int pageNum, HqlHelper hqlHelper) {
		return baseDaoImpl.getPageBean(pageNum, hqlHelper);
	}

}

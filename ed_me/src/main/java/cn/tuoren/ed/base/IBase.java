package cn.tuoren.ed.base;

import java.util.List;

import cn.tuoren.ed.util.HqlHelper;


/**
 * Dao接口
 * @author wangqing 2018-12-4
 *
 * @param <T>
 */


public interface IBase<T> {
	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);
	/**
	 * 删除实体
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 修改实体
	 * @param entity
	 */
	void update(T entity);
	/**
	 * 根据ID查询单个实体
	 * @param id
	 * @return
	 */
	T getById(Long id);
	/**
	 * 根据名称查询
	 * @param name
	 * @return
	 */
	T getByName(String name);
	/**
	 * 根据ID数组查询实体列表
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	/**
	 * 查询所有
	 * @return
	 */
	List<T> getAll();
	/**
	 * 分页查询公共方法
	 * @param currentPageCode
	 * @param sql
	 * @param params
	 * @return
	 */
	@Deprecated
	PageBean<T> getPageBean(int currentPageCode,String sql,Object[] params);
	
	/**
	 * 公共的查询分页信息的方法
	 * 
	 * @param pageNum
	 * @param hqlHelper
	 *            查询条件（HQL语句与参数列表）
	 * @return
	 */
	
	PageBean<T> getPageBean(int pageNum, HqlHelper hqlHelper);
}

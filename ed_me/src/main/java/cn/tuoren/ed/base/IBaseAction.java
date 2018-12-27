package cn.tuoren.ed.base;

public interface IBaseAction {
	/**
	 * save
	 * @return
	 */
	String save();
	/**
	 * delete
	 * @return
	 */
	String delete();
	/**
	 * edit
	 * @return
	 */
	String edit();
	/**
	 * list
	 * @return
	 */
	String list();
	/**
	 * to addUI.jsp
	 * @return
	 */
	String addUI();
	/**
	 * to editUI.jsp
	 * @return
	 */
	String editUI();
}

package cn.tuoren.ed.view.action;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tuoren.ed.base.BaseAction;
import cn.tuoren.ed.domain.Book;

/**
 * 工作流程运行管理
 * @author wangqing
 * @version 1.0.0	2018-12-11
 *
 */
//@Controller
//@Scope("prototype")
public class RunningWorkflowAction extends BaseAction<Book> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 删除
	 * @return
	 */
	public String delete() {
		return "toList";
	}
	
	/**
	 * 挂起
	 * @return
	 */
	public String suspend() {
		return "toList";
	}
	/**
	 * 预览
	 * @return
	 */
	public String detial() {
		return "detail";
	}
	
}

package cn.tuoren.ed.view.action;



import java.util.List;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.tuoren.ed.base.BaseAction;
import cn.tuoren.ed.base.IBaseAction;
import cn.tuoren.ed.domain.Book;

/**
 * 图书管理
 * @author wangqing
 * @version v1.0.0  2018-12-11
 */

@Controller
public class BookAction extends BaseAction<Book> implements IBaseAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 保存后转发到list.jsp
	 */
	@Override
	public String save() {
        List<Book> lists=bookService.getAll();
        ActionContext.getContext().put("bookList", lists);
		return "toList";
	}
	/**
	 * 删除后转发到list.jsp
	 */
	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return "toList";
	}
	/**
	 * 修改后转发到list.jsp
	 */
	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return "toList";
	}
	/**
	 * 转发查询列表页面
	 */
	@Override
	public String list() {
		// TODO Auto-generated method stub
		return "list";
	}
	/**
	 * 重定向到添加页面
	 */
	@Override
	public String addUI() {
		// TODO Auto-generated method stub
		return "addUI";
	}
	/**
	 * 重定向到编辑页面
	 */
	@Override
	public String editUI() {
		// TODO Auto-generated method stub
		return "editUI";
	}
	/**
	 * 重定向到 借书jsp页面
	 * @return
	 */
	public String borrowUI() {
		return "borrowUI";
	}
	/**
	 * 重定向到 还书jsp页面
	 * @return
	 */
	public String returnUI() {
		return "returnUI";
	}
}

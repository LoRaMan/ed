package cn.tuoren.ed.view.action;




import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import cn.tuoren.ed.base.BaseAction;
import cn.tuoren.ed.base.IBaseAction;
import cn.tuoren.ed.domain.Book;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 图书管理
 * @author wangqing
 * @version v1.0.0  2018-12-11
 */

@RestController
@Scope("prototype")
public class BookAction extends BaseAction<Book> implements IBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String fun() {
		
		System.out.println(ServletActionContext.getRequest().getParameter("amount"));
		return "toList";
	}
	/**
	 * 保存后转发到list.jsp
	 */
	@Override
	public String save() {
	    String strJson=model.getBookName();
		System.out.println("strJson"+strJson);
		JSONObject sfObject=JSONObject.fromObject(strJson);
		Book book=(Book) JSONObject.toBean(sfObject,Book.class);
		System.out.println(book.getBookName()+":"+book.getBookAuthor());
        bookService.save(book);
		return "toList";
	}
	/**
	 * 删除后转发到list.jsp
	 */
	@Override
	public String delete() {
		bookService.delete(model.getBookId());
		return "toList";
	}
	/**
	 * 修改后转发到list.jsp
	 */
	@Override
	public String edit() {
		Book book = new Book();
		book.setBookId(model.getBookId());
		book.setISBN_Number(model.getISBN_Number());
		book.setBookCategory(model.getBookCategory());
		book.setBookName(model.getBookName());
		book.setBookAuthor(model.getBookAuthor());
		book.setVersion(model.getVersion());
		book.setBookPrice(model.getBookPrice());
		book.setBookShelf(model.getBookShelf());
		book.setAmount(model.getAmount());
		book.setSynopsis(model.getSynopsis());
		bookService.update(book);
		return "toList";
	}
	/**
	 * 转发查询列表页面
	 */
	@Override
	public String list() {
		List<Book> lists=bookService.getAll();
        ActionContext.getContext().put("bookList", lists);
       
		return "list";
	}
	/**
	 * 重定向到添加页面
	 */
	@Override
	public String addUI() {
		System.out.println("访问");
		
		return "addUI";
	}
	/**
	 * 重定向到编辑页面
	 */
	@Override
	public String editUI() {
		Book book = bookService.getById(model.getBookId());
		ActionContext.getContext().put("bookedit", book);
		return "editUI";
	}
	/**
	 * 重定向到 借书jsp页面
	 * @return
	 */
	public String borrowUI() {
		Book book = bookService.getById(model.getBookId());
		ActionContext.getContext().put("bookborrow", book);
		return "borrowUI";
	}
	/**
	 * 重定向到 还书jsp页面
	 * @return
	 */
	public String returnUI() {
		Book book = bookService.getById(model.getBookId());
		ActionContext.getContext().put("bookreturn", book);
		return "returnUI";
	}
	public String queryByName() {
		System.out.println(model.getBookName());
		List<Book>lists= bookService.queryByName(model.getBookName());
		System.out.println(lists);
		 ActionContext.getContext().put("bookList", lists);
		return "queryResult";
	}
}

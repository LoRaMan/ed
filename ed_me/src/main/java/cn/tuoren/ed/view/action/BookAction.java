package cn.tuoren.ed.view.action;

import java.util.List;

//import javax.swing.event.ListSelectionEvent;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;
//import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import cn.tuoren.ed.base.BaseAction;
import cn.tuoren.ed.base.IBaseAction;
import cn.tuoren.ed.base.PageBean;
import cn.tuoren.ed.config.Configuration;
import cn.tuoren.ed.domain.Book;
import cn.tuoren.ed.domain.BorrowRecord;
import cn.tuoren.ed.util.HqlHelper;
import net.sf.json.JSONObject;

/**
 * 图书管理
 * @author 郭果
 * @version v1.0.0  2018-12-11
 */

@RestController
@Scope("prototype")
public class BookAction extends BaseAction<Book> implements IBaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resultdata;
	
	
	public String getResultdata() {
		return resultdata;
	}

	public void setResultdata(String resultdata) {
		this.resultdata = resultdata;
	}
	/**
	 * 保存后转发到list.jsp
	 */
	@Override
	public String save() {
		//bookService.save(model);
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
		System.out.println("删除操作");
		String list=ServletActionContext.getRequest().getParameter("params");
		System.out.println(list);
		JSONObject jsonObject = JSONObject.fromObject(list);
		long bookId=Long.valueOf(String.valueOf(jsonObject.get("bookId"))) ;
		bookService.delete(bookId);
		resultdata="1";
		return "delete";
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
		System.out.println("*******************");
		return "list";
	}
	public String listTwo() {
		System.out.println("*******************");
		int pageSize=10;
		int currentPage=1;
		String list=ServletActionContext.getRequest().getParameter("params");
		if(list==null) {
			System.out.println("list is null");
		}else {
			System.out.println("list is not null");
			JSONObject jsonObject = JSONObject.fromObject(list);
			pageSize=(int) jsonObject.get("size");
			currentPage=(int)jsonObject.get("page");
			
		}
		System.out.println("pageSize"+pageSize);
		System.out.println("currentPage"+currentPage);
		Configuration.pageSize=pageSize;
		HqlHelper hqlHelper=new HqlHelper(Book.class);
		hqlHelper.addOrder("bookName", true);
		PageBean pBean= hqlHelper.returnPageBean(currentPage,bookService);
		System.out.println(pBean.getTotalPages()+"/"+pBean.getRecordList().size());
		resultdata=JSONObject.fromObject(pBean).toString();
		System.out.println("resultdata"+resultdata);
		return "listTwo";
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
		List<BorrowRecord>lists = borrowRecordService.querybyborrowedStatus("未借出");
		ActionContext.getContext().put("borrowedStatus", lists);
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

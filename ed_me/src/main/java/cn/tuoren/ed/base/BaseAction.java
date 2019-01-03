package cn.tuoren.ed.base;

import java.lang.reflect.ParameterizedType;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import cn.tuoren.ed.domain.User;
import cn.tuoren.ed.service.ApproveService;
import cn.tuoren.ed.service.AuditService;
import cn.tuoren.ed.service.AuthenticationService;
import cn.tuoren.ed.service.BookService;
import cn.tuoren.ed.service.BorrowRecordService;
import cn.tuoren.ed.service.DepartmentService;
import cn.tuoren.ed.service.FileCategoryService;
import cn.tuoren.ed.service.FileService;
import cn.tuoren.ed.service.MenuService;
import cn.tuoren.ed.service.MessageService;
import cn.tuoren.ed.service.ProjectService;
import cn.tuoren.ed.service.RoleService;
import cn.tuoren.ed.service.UserService;




@SuppressWarnings({ "rawtypes", "unchecked"})
public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	private static final long serialVersionUID = 1L;

	@Resource
	protected DepartmentService departmentService;
	@Resource
	protected BookService bookService;
	@Resource
	protected FileService fileService;
	@Resource
	protected UserService userService;
	@Resource
	protected RoleService roleService;
	@Resource
	protected ProjectService projectService;
	@Resource
	protected MessageService messageService;
	@Resource
	protected MenuService menuService;
	@Resource
	protected AuthenticationService authenticationService;
	@Resource
	protected BorrowRecordService borrowRecordService;
	@Resource
	protected AuditService auditService;
	@Resource
	protected ApproveService approveService;
	@Resource
	protected FileCategoryService fileCategoryService;
	
	protected T model;

	public BaseAction() {
		try {
			
			// 得到model的类型信息
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class clazz = (Class) pt.getActualTypeArguments()[0];
			
			// 通过反射生成model的实例
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public T getModel() {
		return model;
	}

	/**
	 * 获取当前登录的用户
	 * 
	 * @return
	 */
	protected User getCurrentUser() {
		return (User) ActionContext.getContext().getSession().get("user");
	}
	
	// 页码默认为第1页
	protected int pageNum = 1;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
}

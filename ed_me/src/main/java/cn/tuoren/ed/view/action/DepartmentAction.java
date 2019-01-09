package cn.tuoren.ed.view.action;

import java.util.List;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.tuoren.ed.base.BaseAction;
import cn.tuoren.ed.base.IBaseAction;
import cn.tuoren.ed.domain.Department;
import cn.tuoren.ed.util.HqlHelper;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> implements IBaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String save() {
		departmentService.save(model);
		return "toList";
	}

	@Override
	public String delete() {
		departmentService.delete(model.getDepartmentId());
		return "toList";
	}

	@Override
	public String edit() {
		departmentService.update(model);
		return "toList";
	}

	@Override
	public String list() {
		//new HqlHelper(Department.class).buildPageBeanForStruts2(pageNum, departmentService);
		List<Department> list=departmentService.getAll();
		ActionContext.getContext().put("departmentList", list);
		return "list";
	}

	@Override
	public String addUI() {
		return "addUI";
	}

	@Override
	public String editUI() {
		Department department=departmentService.getById(model.getDepartmentId());
		ActionContext.getContext().getValueStack().push(department);
		return "editUI";
	}

}

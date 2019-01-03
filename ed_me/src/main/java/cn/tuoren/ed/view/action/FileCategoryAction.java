package cn.tuoren.ed.view.action;



import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import cn.tuoren.ed.base.BaseAction;
import cn.tuoren.ed.base.IBaseAction;
import cn.tuoren.ed.domain.FileCategory;

/**
 * 
 * @author wangqing
 * @version 1.0.0	2018-12-11
 *
 */
@Controller
@Scope("prototype")
public class FileCategoryAction extends BaseAction<FileCategory> implements IBaseAction{
	private static final long serialVersionUID = 1L;

	@Override
	public String save() {
		try {
			fileCategoryService.save(model);
			ActionContext.getContext().put("msg", "保存成功！");
		} catch (Exception e) {
			ActionContext.getContext().put("msg", "保存失败，请检查是否已存在该类别!");
			return "input";
		}
		return "input";
	}

	@Override
	public String delete() {
		fileCategoryService.delete(model.getCategoryId());
		return "toList";
	}

	@Override
	public String edit() {
		fileCategoryService.update(model);
		return "toList";
	}

	@Override
	public String list() {
		List<FileCategory> categoryList=fileCategoryService.getAll();
		ActionContext.getContext().put("categoryList", categoryList);
		return "list";
	}

	@Override
	public String addUI() {
		return "addUI";
	}

	@Override
	public String editUI() {
		FileCategory fileCategory=fileCategoryService.getById(model.getCategoryId());
		ActionContext.getContext().getValueStack().push(fileCategory);
		ServletActionContext.getRequest().setAttribute("fileCategory", fileCategory);
		return "editUI";
	}
}

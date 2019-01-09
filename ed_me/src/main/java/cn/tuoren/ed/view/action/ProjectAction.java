package cn.tuoren.ed.view.action;



import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tuoren.ed.base.BaseAction;
import cn.tuoren.ed.base.IBaseAction;
import cn.tuoren.ed.domain.Project;
import cn.tuoren.ed.util.Struts2Util;

/**
 * 项目管理
 * @author wangqing
 * @version 1.0.0	2018-12-11
 *
 */

@Controller
@Scope("prototype")
public class ProjectAction extends BaseAction<Project> implements IBaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String save() {
		projectService.save(model);
		return "toList";
	}

	@Override
	public String delete() {
		projectService.delete(model.getProjectId());
		return "toList";
	}

	@Override
	public String edit() {
		projectService.update(model);
		return "toList";
	}

	@Override
	public String list() {
		List<Project> projects=projectService.getAll();
		Struts2Util.put("projectList", projects);
		return "list";
	}

	@Override
	public String addUI() {
		return "addUI";
	}

	@Override
	public String editUI() {
		Project project=projectService.getById(model.getProjectId());
		Struts2Util.push(project);
		return "editUI";
	}
}

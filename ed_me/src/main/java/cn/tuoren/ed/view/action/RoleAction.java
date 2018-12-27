package cn.tuoren.ed.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tuoren.ed.base.BaseAction;
import cn.tuoren.ed.base.IBaseAction;
import cn.tuoren.ed.domain.Role;

/**
 * 角色管理
 * @author wangqing
 * @version 1.0.0	2018-12-11
 *
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> implements IBaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String save() {
		// TODO Auto-generated method stub
		return "toList";
	}

	@Override
	public String delete() {
		// TODO Auto-generated method stub
		return "toList";
	}

	@Override
	public String edit() {
		// TODO Auto-generated method stub
		return "toList";
	}

	@Override
	public String list() {
		// TODO Auto-generated method stub
		return "list";
	}

	@Override
	public String addUI() {
		// TODO Auto-generated method stub
		return "addUI";
	}

	@Override
	public String editUI() {
		// TODO Auto-generated method stub
		return "editUI";
	}

}

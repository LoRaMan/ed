package cn.tuoren.ed.view.action;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tuoren.ed.base.BaseAction;
import cn.tuoren.ed.base.IBaseAction;
import cn.tuoren.ed.domain.User;

/**
 * 用户管理
 * @author wangqing
 * @version 1.0.0	2018-12-11
 *
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> implements IBaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String save() {
		
		return "toList";
	}

	@Override
	public String delete() {
		return "toList";
	}

	@Override
	public String edit() {
		return "toList";
	}

	@Override
	public String list() {
		return "list";
	}

	@Override
	public String addUI() {
		return "addUI";
	}

	@Override
	public String editUI() {
		return "editUI";
	}
	/**
	 * 初始化密码为“123456”
	 * @return
	 */
	public String initPassword() {
		return "initPassword";
	}
	/**
	 * 登录页面
	 * @return
	 */
	public String loginUI() {
		return "loginUI";
	}
	/**
	 * 登录
	 * @return
	 */
	public String login() {
		return "login";
	}
	/**
	 * 注销
	 * @return
	 */
	public String logout() {
		return "logout";
	}
}

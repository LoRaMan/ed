package cn.tuoren.ed.view.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.HttpParameters;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import cn.tuoren.ed.base.BaseAction;
import cn.tuoren.ed.base.IBaseAction;
import cn.tuoren.ed.domain.Role;
import net.sf.json.JSONObject;


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
	private String msg;
	private String resultdata;
	
	
	public String getResultdata() {
		return resultdata;
	}

	public void setResultdata(String resultdata) {
		this.resultdata = resultdata;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

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
		List<Role> roleList=roleService.getAll();
		ActionContext.getContext().put("roles", roleList);
		// TODO Auto-generated method stub
		return "list";
	}

	@Override
	public String addUI() {
		System.out.println("readForm2........");
		// TODO Auto-generated method stub
		return "addUI";
	}
	//添加角色
	public void addRole() {
		System.out.println("-------添加角色Start--------");
		String roleName=ServletActionContext.getRequest().getParameter("params");
		System.out.println(roleName);
		JSONObject jsonObject1 = JSONObject.fromObject(roleName);
		Role role = (Role) JSONObject.toBean(jsonObject1,Role.class);
		//Role newRole=()JSON.toJavaObject(roleName, Role.class);
		//List<Role> roles=roleService.getAll();
		//List<Role> roles=roleService.getRoleByName("郭果", "asd");
		//resultdata=JSON.toJSONString(roles);
		//System.out.println(resultdata);
		try {
			roleService.save(role);
			ServletActionContext.getResponse().getWriter().println("1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------添加角色End--------");
	}
	//授权
	public String shouQuan() {
		System.out.println("-------授权Start--------");
		//doSomething
		System.out.println("-------授权End--------");
		return "shouQuan";
		
	}
	//授权功能菜单
	public String shouQuanGNmenu() {
		System.out.println("-------授权功能菜单Start--------");
		//doSomething
		System.out.println("-------授权功能菜单End--------");
		return "shouQuanGNmenu";
	}
	//shuJuQXFenPei数据权限分配
	public String shuJuQXFenPei() {
		System.out.println("-------数据权限分配Start--------");
		//doSomething
		System.out.println("-------数据权限分配End--------");
		return "shuJuQXFenPei";
	}
	//数据权限管理shuJuQXGuanLi
	public String shuJuQXGuanLi() {
		System.out.println("-------数据权限管理Start--------");
		//doSomething
		System.out.println("-------数据权限管理End--------");
		return "shuJuQXGuanLi";
	}
	//yongHuGuanLi用户管理
	public String yongHuGuanLi() {
		System.out.println("-------用户管理Start--------");
		//doSomething
		System.out.println("-------用户管理End--------");
		return "yongHuGuanLi";
	}
	//bianJiJueSe编辑角色
	public String bianJiJueSe() {
		System.out.println("-------编辑角色Start--------");
		//doSomething
		System.out.println("-------编辑角色End--------");
		return "bianJiJueSe";
	}
	//JueSeSQYongHu角色授权用户
	public String JueSeSQYongHu() {
		System.out.println("-------角色授权用户Start--------");
		//doSomething
		System.out.println("-------角色授权用户End--------");
		return "JueSeSQYongHu";
	}
	//JueSeQXFenPei角色权限分配
	public String JueSeQXFenPei() {
		System.out.println("-------角色权限分配Start--------");
		//doSomething
		System.out.println("-------角色权限分配End--------");
		return "JueSeQXFenPei";
	}
	//JueSeAddYongHu角色添加用户
	public String JueSeAddYongHu() {
		System.out.println("-------角色添加用户Start--------");
		//doSomething
		System.out.println("-------角色添加用户End--------");
		return "JueSeAddYongHu";
	}

	@Override
	public String editUI() {
		// TODO Auto-generated method stub
		return "editUI";
	}
}

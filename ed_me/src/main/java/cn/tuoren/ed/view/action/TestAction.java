package cn.tuoren.ed.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;


@Controller
@Scope("prototype")
public class TestAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String test() throws Exception {
		return "test";
	}
	public String test1() throws Exception {
		return "test1";
	}
	public String test2() throws Exception {
		return "test2";
	}
}

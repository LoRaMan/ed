package cn.tuoren.ed.view.action;



import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import cn.tuoren.ed.base.BaseAction;
import cn.tuoren.ed.base.IBaseAction;
import cn.tuoren.ed.domain.EdFile;

/**
 * 文件管理
 * @author wangqing
 * @version v1.0.0  2018-12-11
 *
 */
@Controller
@Scope("prototype")
public class FileAction extends BaseAction<EdFile> implements IBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 保存到数据库后转发到列表页面
	 */
	@Override
	public String save() {
		fileService.save(model);
		return "toList";
	}
	/**
	 * 删除数据后转发到列表页面
	 */
	@Override
	public String delete() {
		fileService.delete(model.getFileId());
		return "toList";
	}
	/**
	 * 更新数据后转发到列表页面
	 */
	@Override
	public String edit() {
		fileService.update(model);
		return "toList";
	}
	/**
	 * 从数据库查询数据，显示到列表页面
	 */
	@Override
	public String list() {
		List<EdFile> files=fileService.getAll();
		ActionContext.getContext().put("fileList", files);
		return "list";
	}
	
	/**
	 * 转到新增页面
	 */
	@Override
	public String addUI() {
		return "addUI";
	}

	/**
	 * 根据传递的Id值，到后台查询到完整的对象，再转发到编辑页面
	 */
	@Override
	public String editUI() {
		EdFile file=fileService.getById(model.getFileId());
		ActionContext.getContext().getValueStack().push(file);
		return "editUI";
	}
	/**
	 * 文件提交审核
	 * @return
	 */
	public String fileAudit() {
		//todo
		return "fileAudit";
	}

}

package cn.tuoren.ed.view.action;

import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import cn.tuoren.ed.base.BaseAction;
import cn.tuoren.ed.base.IBaseAction;
import cn.tuoren.ed.domain.EdFile;
import cn.tuoren.ed.domain.FileCategory;
import cn.tuoren.ed.domain.Project;
import cn.tuoren.ed.util.Struts2Util;

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
	private Long projectId;
	private Long categoryId;
	private String fileName;
	/**
	 * 保存到数据库后转发到列表页面
	 */
	@Override
	public String save() {
		Project project = projectService.getById(projectId);
		model.setProject(project);

		FileCategory category=fileCategoryService.getById(categoryId);
		model.setCategory(category);
		//保存成功返回添加页面，并返回成功消息；保存失败，转到error.jsp页面，提示失败。
		try {
			fileService.save(model);
			Struts2Util.put("msg", "添加成功！");
		} catch (Exception e) {
			Struts2Util.put("msg", "添加失败,请检查该文件是否已存在！");
		}
		return "input";
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
		Struts2Util.put("fileList", files);
		for (EdFile edFile : files) {
			System.out.println(edFile.getCategory().getCategoryName());
		}
		return "list";
	}
	
	/**
	 * 转到新增页面
	 */
	@Override
	public String addUI() {
		//获取分类列表
		List<FileCategory> categoryList=fileCategoryService.getAll();
		Struts2Util.put("categoryList", categoryList);
		//获取项目列表
		List<Project> projectList=projectService.getAll();
		Struts2Util.put("projectList", projectList);
		return "addUI";
	}

	/**
	 * 根据传递的Id值，到后台查询到完整的对象，再转发到编辑页面
	 */
	@Override
	public String editUI() {
		//获取分类列表
		List<FileCategory> categoryList=fileCategoryService.getAll();
		Struts2Util.put("categoryList", categoryList);
		//获取项目列表
		List<Project> projectList=projectService.getAll();
		Struts2Util.put("projectList", projectList);
		
		EdFile file=fileService.getById(model.getFileId());
		Struts2Util.push(file);
		return "editUI";
	}
	
	public void nameCheck() {
		
	}
	
	/**
	 * 文件提交审核
	 * @return
	 */
	public String fileAudit() {
		//todo
		return "fileAudit";
	}
	
	
	//属性的get/set方法
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}

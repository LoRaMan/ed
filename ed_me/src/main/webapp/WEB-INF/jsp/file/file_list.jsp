<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>文件列表</title>
    <%@ include file="/WEB-INF/jsp/public/repository.jspf" %>
</head>
<body>
    <div style="border-bottom: black;padding: 5px;font-family: 隶书"><h3>文件列表</h3></div>
    <div class="container-fluid">
        <div id="search" class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-md-3">
                        <a href="javascript:void(0)" onclick="self.parent.addTab('文件添加','fileAction_addUI.action')" class="easyui-linkbutton" iconCls="icon-add">添加</a>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-ok">提交</a>
                    </div>
                    <div class="col-md-9">
                        <form role="form" class="form-inline">
                            <div class="form-group">
                                <label>名称:</label><input type="text" class="form-control form-control-sm" placeholder="文件名">
                                <label>版本:</label><input type="text" class="form-control form-control-sm" placeholder="版本">
                                <label>分类:</label><input type="text" class="form-control form-control-sm" placeholder="类别">
                            </div>
                            <div class="form-group">
                                <label>状态:</label><input type="text" class="form-control form-control-sm" placeholder="状态">
                                <label>类型:</label><input type="text" class="form-control form-control-sm" placeholder="文件类型">
                                <label>上传人:</label><input type="text" class="form-control form-control-sm" placeholder="上传人">
                            </div>
                            <div class="form-group el-steps--horizontal">
                                <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="">查询</a>
                                <a href="#" class="easyui-linkbutton" iconCls="icon-redo" onclick="">重置</a>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
    <table id="tt" class="easyui-datagrid" style="width:100%;height:370px" data-options="rownumbers:false,pagination:false">
        <thead>
            <tr>
                <th data-options="field:'ck',checkbox:true"></th>
                <!-- <th data-options="field:'fileId',width:50">ID</th> -->
                <th data-options="field:'fileName',width:150,align:'center'">文件名称</th>
                <th data-options="field:'category.categoryName',width:100,align:'center'">归属分类</th>
                <th data-options="field:'project.projectName',width:100,align:'center'">归属项目</th>
                <th data-options="field:'fileType',width:70,align:'center'">文件类型</th>
                <th data-options="field:'fileSize',width:100,align:'center'">文件大小</th>
                <th data-options="field:'uploadTime',width:150,align:'center'">上传时间</th>
                <th data-options="field:'uploader',width:100,align:'center'">上传人</th>
                <th data-options="field:'version',width:100,align:'center'">版本</th>
                <th data-options="field:'path',width:100,align:'center'">路径</th>
                <th data-options="field:'opertion',width:150,align:'center'">操作</th>
            </tr>
        </thead>
        <tbody>
        	<s:iterator value="#fileList">
	        	<tr>
	        		<td></td>
	        		<%-- <td><s:property value="fileId"/></td> --%>
	        		<td><s:a href="#"><s:property value="fileName"/></s:a></td>
	        		<td><s:property value="category.categoryName"/></td>
	        		<td><s:property value="project.projectName"/></td>
	        		<td><s:property value="fileType"/></td>
	        		<td><s:property value="fileSize"/>kB</td>
	        		<td><s:property value="uploadTime"/></td>
	        		<td><s:property value="uploader"/></td>
	        		<td><s:property value="version"/></td>
	        		<td><s:property value="path"/></td>
	        		<td>
	        			<s:a onclick="self.parent.addTab('文件编辑','fileAction_editUI.action?fileId=%{fileId}')">修改</s:a>
	        			<s:a action="fileAction_delete?fileId=%{fileId}" onclick="return window.confirm('您确定要删除该文件吗？')">删除</s:a>
	        			<s:a action="downloadAction?fileName=%{path}">下载</s:a>
	        		</td>
	        	</tr>
        	</s:iterator>
        </tbody>
        
    </table>
</body>


</html>
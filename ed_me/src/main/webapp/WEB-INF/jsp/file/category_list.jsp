<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>分类列表</title>
	    <%@ include file="/WEB-INF/jsp/public/repository.jspf" %>

	</head>
	<body>
		<div style="border-bottom: black;padding: 5px;font-family: 隶书;"><h3>分类列表</h3></div>
		<div class="container-fluid">
		    <div id="search" class="row">
		        <div class="col-md-12">
		            <div class="row">
		                <div class="col-md-4">
		                	<s:a href="#" onclick="self.parent.addTab('分类添加','fileCategoryAction_addUI.action')" class="easyui-linkbutton" iconCls="icon-add">add</s:a>
		                	<%-- <s:a action="fileCategoryAction_delete" class="easyui-linkbutton" iconCls="icon-remove">Remove</s:a> --%>
		                </div>
			            <div class="col-md-8">
		                    <form action="#" role="form" class="form-inline">
		                        <div class="form-group">
		                            <input type="text" class="form-control form-control-sm" placeholder="名称">
				                    <button class="btn btn-default" type="button">Search</button>
		                        </div>
		                    </form>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
		<table class="easyui-datagrid" style="width:100%;height:480px" data-options="rownumbers:true,pagination:true">
	        <thead>
	            <tr>
	                <th data-options="field:'categoryId',width:100">ID</th>
	                <th data-options="field:'categoryName',width:300">分类名称</th>
	                <th data-options="field:'remarks',width:500">分类描述</th>
	                <th data-options="field:'operation',width:200">操作</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<s:iterator value="#categoryList">
	        		<tr>
	        			<td><s:property value="categoryId"/></td>
						<td><s:property value="categoryName"/></td>
						<td><s:property value="remarks"/></td>
						<td>
							<s:a action="fileCategoryAction_delete?categoryId=%{categoryId}" onclick="return window.confirm('您确定要删除该类别吗？')">删除</s:a>
							<s:a action="fileCategoryAction_editUI?categoryId=%{categoryId}">修改</s:a>
						</td>
	        		</tr>
	        	</s:iterator>
	        </tbody>
	    </table>
	</body>
</html>
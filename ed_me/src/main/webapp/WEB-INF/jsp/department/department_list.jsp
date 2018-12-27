<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>部门列表</title>
	<%@ include file="/WEB-INF/jsp/public/repository.jspf" %>
</head>
<body>
	<!-- 添加功能超链接 -->
    <div>
        <div id="TableTail_inside">
            <s:a action="departmentAction_addUI">添加部门</s:a>
        </div>
    </div>
	<div>
		<table>
			<thead>
				<tr>
					<td>ID</td>
					<td>名称</td>
					<td>描述</td>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#departmentList">
					<tr>
						<td><s:property value="departmentId"/></td>
						<td><s:property value="departmentName"/></td>
						<td><s:property value="remarks"/></td>
						<td>
							<s:a action="departmentAction_delete?departmentId=%{departmentId}" onclick="return window.confirm('您确定要删除该部门吗？')">删除</s:a>
							<s:a action="departmentAction_editUI?departmentId=%{departmentId}">修改</s:a>
						</td>
					</tr>
				</s:iterator>
				<s:if test="#departmentList.size()==0">
					<tr><td>没有查询到数据</td></tr>
				</s:if>
			</tbody>
		</table>
	</div>

</body>
</html>
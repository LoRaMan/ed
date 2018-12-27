<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>部门编辑</title>
	<%@ include file="/WEB-INF/jsp/public/repository.jspf" %>
</head>
<body>
	<h1>编辑部门</h1>
	<div>
		<s:form action="departmentAction_edit">
			<s:hidden name="departmentId"></s:hidden>
			<s:textfield name="departmentName" lable="部门名称" cssClass="InputStyle"></s:textfield>
			<s:textfield name="remarks" lable="部门描述" cssClass="TextareaStyle"></s:textfield>
			<s:submit value="保存" ></s:submit>
			<s:reset value="重置" type="button"></s:reset>
		</s:form>
	</div>
</body>
</html>
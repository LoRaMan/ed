<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>department_editUI</title>
	<%@ include file="/WEB-INF/jsp/public/repository.jspf" %>
	<style>
        h3{
            font-family: 隶书;
        }
        label{
            font-family: 楷体;
        }
    </style>
</head>
<body>
	<div class="container" style="width:60%;height:500px;border-style: ridge;margin-top: 3rem">
        <h3>添加部门</h3>
        <hr/>
        <s:form action="departmentAction_save">
        	<div style="margin-bottom:20px">
                <label>部门名称:</label>
                <s:textfield name="departmentName" class="easyui-textbox" style="width:100%" data-options="required:true"/>
            </div>
            <div style="margin-bottom:20px">
                <label>部门描述:</label>
                <s:textarea name="remarks" class="easyui-textbox" style="width:100%;height:60px" data-options="multiline:true"/>
            </div>
            <div div style="text-align:center; margin: auto">
            	<s:submit value="保存" class="btn btn-success" style="width:80px"></s:submit>
            	&nbsp;&nbsp;&nbsp;&nbsp;
            	<s:reset value="重置" class="btn btn-warning" style="width:80px"></s:reset>
            </div>
        </s:form>
    </div>
</body>
</html>
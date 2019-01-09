<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>部门编辑</title>
        
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
            <h3>部门编辑</h3>
            <hr/>
            <s:form action="departmentAction_edit">
            	<s:hidden name="departmentId"/>
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
                	<s:reset value="重置" type="button" class="btn btn-warning" style="width:80px"></s:reset>
                </div>
            </s:form>
        </div>
    </body>
</html>
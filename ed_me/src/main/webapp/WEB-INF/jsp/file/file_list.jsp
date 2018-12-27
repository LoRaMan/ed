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
                        <a href="javascript:void(0)" onclick="self.parent.addTab('文件编辑','fileAction_addUI.action')" class="easyui-linkbutton" iconCls="icon-edit">编辑</a>
                        <a href="#" class="easyui-linkbutton" iconCls="icon-remove">删除</a>
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
    <table class="easyui-datagrid" style="width:100%;height:480px" data-options="rownumbers:true,pagination:true,url:'',method:'get'">
        <thead>
            <tr>
                <th data-options="field:'ck',checkbox:true"></th>
                <th data-options="field:'itemid',width:100">Item ID</th>
                <th data-options="field:'productid',width:100">Product</th>
                <th data-options="field:'listprice',width:100,align:'right'">List Price</th>
                <th data-options="field:'unitcost',width:100,align:'right'">Unit Cost</th>
                <th data-options="field:'attr1',width:200">Attribute</th>
                <th data-options="field:'status',width:100,align:'center'">Status</th>
            </tr>
        </thead>
    </table>
</body>
</html>
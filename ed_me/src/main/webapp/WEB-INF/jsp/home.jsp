<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
	<%@ include file="/WEB-INF/jsp/public/repository.jspf" %>
</head>
    <body class="easyui-layout">
        <!--头部-->
        <div data-options="region:'north',border:false" style="height:60px;background:#75befa;padding: 10px;">
            <nav>
                <span class="" style="font-size:26px; padding-right:8px;">驼人集团</span>文件管理系统
                <span style="height: 40px; line-height: 40px; float: right; ">
                    <div class="btn btn-group-sm">
                        <a href="#" class="easyui-linkbutton" plain="true"><span class="glyphicon glyphicon-home"></span>首页</a>|
                        <a href="#" class="easyui-menubutton" menu="#mm1"><span class="glyphicon glyphicon-th-list"></span>设置</a>|
                        <a href="#" class="easyui-linkbutton" plain="true"><span class="glyphicon glyphicon-envelope"></span>消息(0)</a>|
                        <a href="#" onclick="addTab('联系我们','/WEB-INF/jsp/help/help.jsp')" class="easyui-linkbutton" plain="true"><span class="glyphicon glyphicon-phone-alt"></span>联系我们</a>|
                        <a href="#" class="easyui-linkbutton" plain="true"><span class="glyphicon glyphicon-off"></span>注销</a>
                    </div>
                </span>
            </nav>
        </div>

        <!--左侧菜单栏，需要根据数据自动生成-->
        <div data-options="region:'west',split:true" title="MENU" style="width:150px;padding:2px;">
            <div class="easyui-accordion" data-options="fit:true,border:false">
                <div title="文件管理" class="card" style="width:18rem;">
                    <div class="list-group">
                        <button type="button" class="list-group-item" onclick="addTab('分类管理','fileCategoryAction_list.action')">分类管理</button>
                        <button type="button" class="list-group-item" onclick="addTab('文件管理','fileAction_list.action')">文件管理</button>
                        <button type="button" class="list-group-item" onclick="addTab('文件批准','fileManagement/fileApprove.html')">文件批准</button>
                        <button type="button" class="list-group-item" onclick="addTab('文件审核','fileManagement/fileAudit.html')">文件审核</button>
                    </div>
                </div>
                <div title="流程管理" class="card" style="width:18rem;">
                    <div class="list-group">
                        <button type="button" class="list-group-item" onclick="addTab('流程列表','progressManagement/progressList.html')">流程列表</button>
                        <button type="button" class="list-group-item" onclick="addTab('运行流程列表','progressManagement/progressRunningList.html')">运行流程列表</button>
                    </div>
                </div>
                <div title="权限管理" class="card" style="width:18rem;">
                    <div class="list-group">
                        <button type="button" class="list-group-item" onclick="addTab('添加角色','pageED/addRole.html')">添加角色</button>
                        <button type="button" class="list-group-item" onclick="addTab('授权','pageED/授权.html')">授权</button>
                        <button type="button" class="list-group-item" onclick="addTab('授权功能菜单','pageED/授权功能菜单.html')">授权功能菜单</button>
                        <button type="button" class="list-group-item" onclick="addTab('数据权限分配','pageED/数据权限分配.html')">数据权限分配</button>
                        <button type="button" class="list-group-item" onclick="addTab('数据权限管理','pageED/数据权限管理.html')">数据权限管理</button>
                        <button type="button" class="list-group-item" onclick="addTab('用户管理','pageED/用户管理.html')">用户管理</button>
                        <button type="button" class="list-group-item" onclick="addTab('编辑角色','pageED/编辑角色.html')">编辑角色</button>
                        <button type="button" class="list-group-item" onclick="addTab('角色授权用户','pageED/角色授权用户.html')">角色授权用户</button>
                        <button type="button" class="list-group-item" onclick="addTab('角色权限分配','pageED/角色权限分配.html')">角色权限分配</button>
                        <button type="button" class="list-group-item" onclick="addTab('角色添加用户','pageED/角色添加用户.html')">角色添加用户</button>
                    </div>
                </div>
                <div title="图书管理" class="card" style="width:18rem;" data-options="selected:true">
                    <div class="list-group">
                        <button type="button" class="list-group-item" onclick="addTab('添加图书','LoginAndBook/bookAdd.html')">添加图书</button>
                        <button type="button" class="list-group-item" onclick="addTab('图书列表','LoginAndBook/bookList.html')">图书列表</button>
                        <button type="button" class="list-group-item" onclick="addTab('图书借阅','LoginAndBook/bookBorrow.html')">图书借阅</button>
                        <button type="button" class="list-group-item" onclick="addTab('图书归还','LoginAndBook/bookReturn.html')">图书归还</button>
                    </div>
                </div>
            </div>
        </div>

        <!--右侧消息栏-->
        <div data-options="region:'east',split:true,collapsed:true,title:'消息栏'" style="width:100px;padding:5px;">
            <button type="button button-sm" class="btn btn-primary">
                未读<span class="badge badge-light"><u>4</u></span>
            </button>
            <button type="button" class="btn btn-primary">
                待处理<span class="badge badge-light"><u>9</u></span>
            </button>
        </div>

        <!--下部状态栏-->
        <div data-options="region:'south',border:false" style="height:30px;background:#75befa;padding:5px;">
            <span>欢迎使用！！！！！！</span>
        </div>

        <!--中间显示区-->
        <div data-options="region:'center'">
            <div id="centerBody" class="easyui-tabs" data-options="tools:'#tab-tools'" style="width:100%;height:98%">
                <div title="首页" data-options="border:true,iframe:true,
                content:'<iframe src=\'fileAction_list.action\' frameborder=\'0\' style=\'width:100%;height:100%;\'></iframe>'"></div>
            </div>
        </div>
        <div id="mm1" style="width:100px;">
            <div><a href="#" plain="true"><span class="glyphicon glyphicon-cog"></span>设置</a></div>
            <div><a href="#" plain="true"><span class="glyphicon glyphicon-edit"></span>修改密码</a></div>
        </div>

        <!--功能-->
        <script type="text/javascript">
            //添加标签页
            function addTab(title, url){
                if ($('#centerBody').tabs('exists', title)){
                    $('#centerBody').tabs('select', title);
                } else {
                    var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
                    $('#centerBody').tabs('add',{
                        title:title,
                        content:content,
                        closable:true
                    });
                }
            }
        </script>
    </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表</title>
<!-- bootstrap -->
	<%@ include file="/WEB-INF/jsp/public/repository.jspf" %>
<style type="text/css">
.alert {
	margin: 20px;
	border-radius: 20px;
	background: linear-gradient(to bottom #FFCCCC 50%, #CCFFCC 50%)
}
.table {

    margin-top: 20px;
}
#TableTail_inside{
	margin-top:15px;
}
.t-font{
	font-size: 15px;
	font-weight: bolder;
}
td{

	text-align: center;
	vertical-align: middle;
}
#footer{
	text-align: center;
}
</style>
</head>
<body>
	<!-- 添加功能超链接 -->
	<div>
		<div id="TableTail_inside">
			<span class="glyphicon glyphicon-plus" style="color: rgb(62, 115, 172);">
				<s:a action="bookAction_addUI.action" id="DownLoadAudio" target="_blank">添加图书</s:a>
			</span>
		</div>
	</div>
	<!-- style="margin-top:15px positon:relative" -->
	 <s:form  action="book_queryByName.action" method="post" style="margin-top:15px;text-align: center;">
		 	<div class="input-group col-md-3" style="margin:0 auto;">
	       		<input type="text" class="form-control"placeholder="请输入书名" name="bookName"/ >
	            <span class="input-group-btn">
	               <button class="btn btn-info btn-search">查找</button>
	            </span>
 			</div>
	</s:form>
	<div>
		<s:if test="#bookList.size()==0">			
			<div id="myAlert" class="alert alert-warning">
				<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>没有查询到数据</strong>
			</div>
		</s:if>
		<s:if test="#bookList.size()!=0"> 
			<table class="table  table-border table table-striped">
				<thead>
					<tr class="t-font">
						<td>书名</td>
						<td>作者</td>
						<td>版本</td>
						<td>出版社</td>
						<td>ISBN编号</td>
						<td>图书价格</td>
						<td>书架</td>
						<td>总量</td>
						<td>已借阅</td>
						<td>可借阅</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#bookList">
						<tr>
							<td><s:property value="bookName" /></td>
							<td><s:property value="bookAuthor" /></td>
							<td><s:property value="version" /></td>
							<td><s:property value="bookPress" /></td>
							<td><s:property value="ISBN_Number" /></td>
							<td><s:property value="bookPrice" /></td>
							<td><s:property value="bookShelf" /></td>
							<td><s:property value="amount" /></td>
							<td><s:property value="borrowed" /></td>
							<td><s:property value="remain" /></td>
							<td><s:a action="bookAction_delete?bookId=%{bookId}"
									onclick="return window.confirm('您确定要删除该图书吗？')"><span class="glyphicon glyphicon-pencil" style="color: rgb(62, 115, 172);">编辑 </span></s:a>
									
							    <s:a action="bookAction_delete?bookId=%{bookId}" onclick="return window.confirm('您确定要删除该图书吗？')"><span class="glyphicon glyphicon-remove" style="color: rgb(62, 115, 172);">删除</span></s:a>
							    <s:a action="bookAction_delete?bookId=%{bookId}"
									onclick="return window.confirm('您确定要删除该图书吗？')">
								<span class="glyphicon glyphicon-share-alt" style="color: rgb(62, 115, 172);">借阅</span></s:a></td>
						</tr>
					</s:iterator>	
				</tbody>
			</table>
			<div id="footer">共10页  
					<select  class="form-control" style="width: 65px;display: inline-block;">
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="30">30</option>
						<option value="40">40</option>
					</select>

		<ul class="pager" style="display:inline-block;">
			<li><a href="#">上一页</a></li>
			<li><a href="#">下一页</a></li>
		</ul>
		前往<input type="number" class="form-control" min="1" max="20" name="goPage" style="width: 60px;display: inline-block;"> 页
	</div>
		</s:if> 
	</div>
	
</body>
<script type="text/javascript">
$(function(){
    $(".close").click(function(){
        $("#myAlert").alert();
    });
});
</script>
</html>
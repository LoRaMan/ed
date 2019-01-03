<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!-- TODO：利用Ajax检查文件是否已存在，后台添加一个检查方法 -->
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="UTF-8">
	    <title>新增文件</title>
		<%@ include file="/WEB-INF/jsp/public/repository.jspf" %>
	    <style>
	        h3{
	            font-family: 隶书;
	        }
	        #bodycontainer{
	            width: 60%;
	            height: 80%;
	            margin-top: 3rem;
	            border-style: ridge;
	
	        }
	    </style>
	</head>
	<body>
		<div class="container" id="bodycontainer" >
		    <h3>新增文件</h3>
		    <hr/>
		    <s:form action="fileAction_save" class="form-horizontal" role="form">
		        <div class="form-group">
		            <div class="row">
		                <label class="col-md-2 control-label">文件名：</label>
		                <div class="col-sm-8">
		                    <input id="fileName" type="text" class="form-control" required="required" name="fileName" value="">
		                    <span id="nameCheck"></span>
		                </div>
		            </div>
		        </div>
		        <div class="form-group">
		            <div class="row">
		                <label class="col-sm-2 control-label">文件版本：</label>
		                <div class="col-sm-8">
		                    <input type="text" class="form-control" required="required" name="version" value="">
		                </div>
		            </div>
		        </div>
		        <div class="form-group">
		            <div class="row">
		                <label class="col-sm-2 control-label">文件分类：</label>
		                <div class="col-sm-8">
		                    <s:select name="categoryId" class="form-control"
		                    	list="#categoryList" listKey="categoryId" listValue="categoryName"
		                    	headerKey="" headerValue="请选择分类">
		                    </s:select>
		                </div>
		            </div>
		        </div>
		        <div class="form-group">
		            <div class="row">
		                <label class="col-sm-2 control-label">归属项目：</label>
		                <div class="col-sm-8">
		                    <s:select name="projectId" class="form-control"
		                    	list="#projectList" listKey="projectId" listValue="projectName"
		                    	headerKey="" headerValue="请选择项目">
		                    </s:select>
		                </div>
		            </div>
		        </div>
		        <div class="form-group">
		            <div class="row">
		                <label class="col-sm-2 control-label">文件类型：</label>
		                <div class="col-sm-8">
		                    <input type="text" class="form-control" required="required" name="fileType" value="">
		                </div>
		            </div>
		        </div>
		        <div class="form-group">
		            <div class="row">
		                <label class="col-sm-2 control-label">保密级别：</label>
		                <div class="col-sm-8">
		                    <input type="text" class="form-control" required="required" name="secretLevel" value="">
		                </div>
		            </div>
		        </div>
		        <div class="form-group">
		            <div class="row">
		                <label class="col-sm-2 control-label">存储路径：</label>
		                <div class="col-sm-8">
		                    <input type="text" class="form-control" required="required" name="path" value="">
		                </div>
		            </div>
		        </div>
		        <div class="form-group">
		            <div class="row">
		                <label class="col-sm-2 control-label">文件状态：</label>
		                <div class="col-sm-8">
		                    <input type="text" class="form-control" required="required" name="fileStatus" value="">
		                </div>
		            </div>
		        </div>
		        
		        <%-- <div class="form-group">
		            <div class="row">
		                <label class="col-sm-2 control-label">文件描述：</label>
		                <div class="col-sm-8">
		                    <textarea rows="5" class="form-control" placeholder="请输入文件描述"></textarea>
		                </div>
		            </div>
		        </div>
		        <div class="form-group">
		            <div class="row">
		                <label class="col-sm-2 control-label">文件上传：</label>
		                <div class="col-sm-8">
		                    <span class="btn btn-success btn-sm">上传</span>
		                    <input type="file" multiple="multiple"/>
		                </div>
		            </div>
		        </div> --%>
		        <hr/>
		        <div class="form-group">
		            <div class="row">
		                <label class="col-sm-5 control-label"></label>
		                <div class="col-sm-5">
		                    <input type="submit" class="btn btn-success" value="Submit">
		                </div>
		            </div>
		        </div>
		    </s:form>
		</div>
		<script type="text/javascript">
			//错误提示信息
		  	var msg=""+'${msg}';
		  	if(msg!=""){
		  		alert(msg);
		  	}

		  	$("#fileName").bind('input propertychange', function(){
			  		var fileName=$("#fileName").val();
			  		var url="fileAction_nameCheck.action?fileName="+fileName;
			  		console.log(url);
			  		$.ajax({
						url:url,
						type:"post",
						dataType:"text",
						success:function(data){
							$("#nameCheck").html(data);
						}
					});
			  	});
		  	
		</script>
	</body>
</html>
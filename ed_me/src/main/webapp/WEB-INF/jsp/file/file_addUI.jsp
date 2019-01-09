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
	            position:relative;
	
	        }
	        #form1Submit{
	        	position: absolute;
			    bottom: -60px;
			    left: calc(50% - 35px);
	        }
	        #form2{
	        	position: absolute;
			    bottom: 2.2%;
			    left: 18%;
			    border: solid 1px #ccc;
			    padding: 5px;
    			border-radius: 5px;
	        }
	        #form2 input{
	        	float:left;
	        	
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
		                <label class="col-sm-2 control-label">文件名称：</label>
		                <div class="col-sm-8">
		                    <input type="text" class="form-control" required="required" name="fileName" value="">
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
		                <label class="col-sm-2 control-label">文件状态：</label>
		                <div class="col-sm-8">
		                    <input type="text" class="form-control" required="required" name="fileStatus" value="">
		                </div>
		            </div>
		        </div>
		        
		        <div class="form-group">
		            <div class="row">
		                <label class="col-sm-2 control-label">文件描述：</label>
		                <div class="col-sm-8">
		                    <textarea name="remarks" rows="2" class="form-control" placeholder="请输入文件描述"></textarea>
		                </div>
		            </div>
		        </div>
		        <div class="form-group">
		            <div class="row">
		                <label class="col-sm-2 control-label">文件上传：</label>
		                <div class="col-sm-8">
		                </div>
		            </div>
		        </div>
		        <div class="form-group" id="form1Submit">
		            <div class="row">
		                <label class="col-sm-5 control-label"></label>
		                <div class="col-sm-5">
		                    <input type="submit" class="btn btn-success" value="Submit">
		                </div>
		            </div>
		        </div>
		        <s:hidden id="uploadedFilePath" name="path" value=""></s:hidden>
		        <s:hidden id="fileSize" name="fileSize" value=""></s:hidden>
		    </s:form>
		    <s:form id="form2" action="uploadAction" method="post" enctype="multipart/form-data">
		        <s:file name="upload" label="选择上传的文件" />
		        <input id="form2Submit" type="button" value="上传">
		        &nbsp;&nbsp;
		        <s:a><span id="uploaded"></span></s:a>
		    </s:form>
		</div>
		
		<script type="text/javascript">
			//错误提示信息
		  	var msg=""+'${msg}';
		  	if(msg!=""){
		  		alert(msg);
		  	}

			//上传文件
		  	$("#form2Submit").click(function(){
		  			getFilePath();
			  	});
			
		  	function getFilePath(){
		  		var formData = new FormData($("#form2")[0]);
				$.ajax({
					url:'uploadAction.action',
					type:"post",
					data:formData,
					processData: false,
					contentType: false,
					dataType:"json",
					success:function(data){
						var obj=$.parseJSON(data);
						$("#uploaded").html(obj.json);
						$("#uploadedFilePath").val(obj.json);
						$("#fileSize").val(obj.fileSize);
						alert(obj.msg);
					},
					error:function(){
						alert("上传失败！");
					}
				});
			}
		</script>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

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
    <form class="form-horizontal" role="form">
        <div class="form-group">
            <div class="row">
                <label class="col-md-2 control-label">文件名：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" required="required" name="" value="">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="row">
                <label class="col-sm-2 control-label">文件版本：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" required="required" name="" value="">
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="row">
                <label class="col-sm-2 control-label">文件分类：</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" required="required" name="" value="">
                </div>
            </div>
        </div>
        <div class="form-group">
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
        </div>
        <hr/>
        <div class="form-group">
            <div class="row">
                <label class="col-sm-5 control-label"></label>
                <div class="col-sm-5">
                    <input type="submit" class="btn btn-success" value="Submit">
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>文件批准</title>
		<%@ include file="/WEB-INF/jsp/public/repository.jspf" %>
        <style>
            span{
                font-family: 隶书;
                font-size: 20px;
            }
            th{
                font-family: 楷体;
            }
        </style>
    </head>
    <body>
        <div style="border-bottom: black;padding: 10px;text-align: center;font-family: 隶书;"><h3>文件批准</h3></div>
        <div class="container-fluid" style="width:60%;">
            <div class="row" style="border-style: ridge">
                <div class="col-md-1">
                    <span><b>待审：</b></span>
                </div>
                <div class="col-md-11">
                    <table class="table table-condensed">
                        <tbody>
                        <tr>
                            <th width="20%">文件名：</th>
                            <td>xxxxxx.rar</td>
                        </tr>
                        <tr>
                            <th width="20%">附件：</th>
                            <td><a href="#">xxxxxx.rar</a></td>
                        </tr>
                        <tr>
                            <th width="20%">审核意见：</th>
                            <td>通过！</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row" style="border-style: ridge">
                <div class="col-md-1">
                    <span><b>批阅：</b></span>
                </div>
                <div class="col-md-11">
                    <form>
                        <table class="table table-condensed">
                            <tr>
                                <th>
                                    <label>批准意见:</label>
                                </th>
                                <td>
                                    <textarea name="message" rows="5" cols="50" required="required" placeholder="请在此输入批准意见！"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <th><label>附件:</label></th>
                                <td>
                                    <span class="btn btn-success btn-sm">上传</span>
                                    <input type="file" multiple="multiple"/>
                                </td>
                            </tr>
                            <!--<tr>-->
                                <!--<td></td>-->
                                <!--<td>-->
                                    <!--<button type="button" class="btn btn-success" onclick="">同意</button>-->
                                    <!--<button type="button" class="btn btn-warning" onclick="">退回</button>-->
                                <!--</td>-->
                            <!--</tr>-->
                        </table>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6" style="text-align: center"><button type="button" class="btn btn-success" onclick="">同意</button></div>
                <div class="col-md-6" style="text-align: center"><button type="button" class="btn btn-warning" onclick="">退回</button></div>
            </div>
        </div>
    </body>
</html>
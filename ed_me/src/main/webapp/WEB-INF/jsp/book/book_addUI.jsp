<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>添加图书</title>
        <!-- 引入样式 -->
     <%@ include file="/WEB-INF/jsp/public/repository.jspf" %>
   <%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/framework/element/css/element-ui-index.css"></link>
   <script type="text/javascript" src="${pageContext.request.contextPath}/framework/element/js/vue.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/framework/element/js/element-ui-index.js"></script> --%>
        <style>
              .el-input {
                width: 300px;
                margin: auto;
            }
            .el-input__inner {
                border: 1px solid #ddbff1;
                background: white;
                border-radius: 20px;
                color: #1a1e23;
                font-size: larger;
            }
            #app {
                margin: auto;
                text-align: center;
                width: 500px;
                margin-top: 50px;
                background:oldlace;
            }
            .el-form-item__error{
                color: #f54508;
                font-size: 12px;
                line-height: 1;
                padding-top: 4px;
            }
            .el-form-item__label {
                color: #2696ff;
                font-size:18px;
            }
        </style>
    </head>
    <body background="img/messes.png" style="background-repeat: repeat;">
        <div id="app">
            <el-form label-position="right" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="140px" class="demo-ruleForm">
                <el-form-item label="ISBN编号：" prop="ISBNnumbe" >
                    <el-input v-model="ruleForm.ISBNnumbe" placeholder="请输入图书编号"></el-input>
                </el-form-item>
                <el-form-item label="图书分类：" prop="Books_Category">
                    <el-select  v-model="ruleForm.Books_Category" placeholder="请输入图书分类">
                        <el-option label="JAVA" value="shanghai"></el-option>
                        <el-option label="数据库" value="beijing"></el-option>
                        <el-option label="算法" value="beijing"></el-option>
                        <el-option label="结构" value="beijing"></el-option>
                        <el-option label="C#" value="beijing"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="图书名称：" prop="Books_Name">
                    <el-input   v-model="ruleForm.Books_Name" placeholder="请输入书名"></el-input>
                </el-form-item>
                <el-form-item label="图书作者：" prop="Books_Author">
                    <el-input v-model="ruleForm.Books_Author" placeholder="请输入图书作者"></el-input>
                </el-form-item>
                <el-form-item label="版本：" prop="Books_Version">
                    <el-input v-model="ruleForm.Books_Version" placeholder="请输入版本"></el-input>
                </el-form-item>
                <el-form-item label="价格：" prop="Books_Price">
                    <el-input v-model="ruleForm.Books_Price" placeholder="请输入图书价格"></el-input>
                </el-form-item>
                <el-form-item label="书架：" prop="Books_Shelf">
                  <el-select v-model="ruleForm.Books_Shelf" placeholder="请输入图书所属部门/位置">
                        <el-option label="软件组" value="shanghai"></el-option>
                        <el-option label="硬件组" value="beijing"></el-option>
                        <el-option label="文档室" value="beijing"></el-option>
                 </el-select>
                </el-form-item>
                <el-form-item label="总量：" prop="Books_Amount">
                    <el-input v-model="ruleForm.Books_Amount" placeholder="请输入图书总量"></el-input>
                </el-form-item>
                <el-form-item label="简介：" prop="Books_Synopsis">
                    <el-input v-model="ruleForm.Books_Synopsis" placeholder="请输入图书简介"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="resetForm('ruleForm')" round>重置</el-button>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <el-button @click="submitForm('ruleForm')" type="primary" round>提交</el-button>
                </el-form-item>
            </el-form>
        </div>
        <script type="text/javascript">
        new Vue({
            el: '#app',
            data () {
                var isbn = (rule, value, callback) => {
                    var reg = /^[0-9]+-+[0-9]+-+[0-9]+-+[0-9]+-+[0-9]*$/
                    if (!reg.test(value)){
                        return callback(new Error('ISBN编号由数字和“-”组成如（x-x-x-x-x）'))
                    }else{
                        callback();
                    }
                };
                var author = (rule, value, callback) => {
                    var reg1 = /^([\u4e00-\u9fa5A-Za-z]){0,20}$/;
                    if (!reg1.test(value)){
                        return callback(new Error('可输入中英文数字和特殊字符'))
                    }else{
                        callback();
                    }
                };

                var version = (rule, value, callback) => {
                    var reg2 = /^([\u4e00-\u9fa50-9]){1,4}$/;
                    if (!reg2.test(value)){
                        return callback(new Error('最多只能输入4位中文和数字！'))
                    }else{
                        callback();
                    }
                };
                var name = (rule, value, callback) => {
                    var reg3 = /^([\u4e00-\u9fa5A-Za-z0-9%,&=$？?#\x22]){1,20}$/;
                    if (!reg3.test(value)){
                        return callback(new Error('可输入中英文数字和特殊字符'))
                    }else{
                        callback();
                    }
                };

                var amount = (rule, value, callback) => {
                    var reg4 = /^([0-9]){0,3}$/;
                    if (!reg4.test(value)){
                        return callback(new Error('最多仅能输入3位数字！'))
                    }else{
                        callback();
                    }
                };

                var price = (rule, value, callback) => {
                    var reg5 = /^([0-9.\x22]){1,10}$/;
                    if (!reg5.test(value)){
                        return callback(new Error('例如（11.50）！'))
                    }else{
                        callback();
                    }
                };

                var synopsis = (rule, value, callback) => {
                    var reg6 = /^([\u4e00-\u9fa5A-Za-z0-9^%&',;=?？：，。、 “”|（）{}；$#\x22]){0,200}$/;
                    if (!reg6.test(value)){
                        return callback(new Error('仅可输入0-200字'))
                    }else{
                        callback();
                    }
                };

                return {
                    input2: "",
                    ruleForm: {
                        ISBNnumbe: '',
                        Books_Category: '',
                        Books_Name: '',
                        Books_Author: '',
                        Books_Version: '',
                        Books_Price: '',
                        Books_Shelf: '',
                        Books_Amount: '',
                        Books_Synopsis: '',
                    },
                    rules: {
                        ISBNnumbe: [
                            {required: true,validator: isbn, trigger: 'change'}
                        ],
                        Books_Category: [
                            {required: true, message: '请选择图书类别', trigger: 'change'}
                        ],
                        Books_Name: [
                            {required: true,validator: name, trigger: 'blur'}
                        ],
                        Books_Author: [
                            {required: true,validator: author, trigger: 'blur'}
                        ],
                        Books_Version: [
                            {required: true,validator: version, trigger: 'blur'}
                        ],
                        Books_Price: [
                            {required: true,validator: price, trigger: 'blur'}
                        ],
                        Books_Shelf: [
                            {required: true, message: '请选择书架所在位置' , trigger: 'change'}
                        ],
                        Books_Amount: [
                            {required: true,validator: amount, trigger: 'blur'}
                        ],
                        Books_Synopsis: [
                            {required: true,validator: synopsis, trigger: 'change'}
                        ]
                    }
                };
            },
         
            methods: {
                submitForm(ruleForm) {
                    this.$refs[ruleForm].validate((valid) => {
                        if (valid) {
                            alert('submit!');
                        } else {
                        	alert('error submit!!!');
                            console.log('error submit!!');
                            return false;
                        }
                    });
                },
                resetForm(ruleForm) {
                    this.$refs[ruleForm].resetFields();
                }
            }
        }) 
        </script>
    </body>
</html>
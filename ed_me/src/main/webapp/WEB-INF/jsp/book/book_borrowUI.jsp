<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图书借阅</title>
   <!-- 引入样式、组件库、VUE -->
         <%@ include file="/WEB-INF/jsp/public/repository.jspf" %>
    <style>
        .el-select{
            width: 100%;
        }
        .el-table .cell{
            text-align: center;
            font-size: 14px;
        }
        .el-tag{
            height: 32px;
            line-height: 30px;
            font-size: 12px;
            border-radius: 0px;
            box-sizing: border-box;
        }
        .el-tag--info, .el-tag--info .el-tag__close{
            color: #2f5d18;

        }
        el-input {
            width: 500px;
            margin: auto;
        }

        .el-input__inner {
            border: 1px solid #ddbff1;
            background: white;
            border-radius: 20px;
            color: #1a1e23;
            font-size: 14px;
        }

        #app {
            margin: auto;
            text-align:left;
            width: 1200px;
            margin-top:48px;
            background:oldlace;

        }

        .el-form-item__error{
            color: #f54508;
            font-size: 10px;
            line-height: 1;
            padding-top: 4px;
            top: 100%;
            left: 0;
            position:initial;
        }

        .el-form-item__label {
            color: #2696ff;
            font-size:16px;
        }
    </style>
</head>

<body style="margin: auto;text-align: center;">
<div id="app">
    <el-tag type="info">读者信息</el-tag>
    <el-form label-position="right" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="200px"
             class="demo-ruleForm">
        <div id="reader" style="margin: auto;text-align: center;width: 607px;font-size: 10px;">

        <el-form-item label="员工工号：" prop="userNumber">
            <el-input v-model="ruleForm.userNumber" placeholder="请输入员工工号"></el-input>
        </el-form-item>
        <el-form-item label="所在部门：" prop="userDepart">
            <el-select  v-model="ruleForm.userDepart" placeholder="请选择所在部门">
                <el-option label="软件部" value="shanghai"></el-option>
                <el-option label="硬件部" value="beijing"></el-option>
                <el-option label="支持部" value="beijing"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="真实姓名：" prop="userName">
            <el-input   v-model="ruleForm.userName" placeholder="请输入真实姓名"></el-input>
        </el-form-item>
        <el-form-item label="联系方式：" prop="phone">
            <el-input v-model="ruleForm.phone" placeholder="请输入手机号码"></el-input>
        </el-form-item>
    </div>
        <el-tag type="info">待借书籍</el-tag> <el-input placeholder="请输入内容"  class="input-with-select">
        <el-button slot="append" icon="el-icon-search"></el-button>
    </el-input>
        <template>
            <el-table
                    ref="multipleTable"
                    :data="tableData3"
                    tooltip-effect="dark"
                    style="width: 100%"
                    @selection-change="handleSelectionChange">
               <!-- <el-table-column
                        type="selection"
                        width="55">
                </el-table-column>-->
               <el-table-column prop="ISBN_numbe"   label="ISBN编号"  width="200">
                </el-table-column>
                <el-table-column  prop="Books_Name" label="图书名称"  width="200">
                </el-table-column>
                <el-table-column prop="Books_Author"   label="图书作者"  width="120">
                </el-table-column>
                <el-table-column prop="Books_Version"   label="版本"  width="120">
                </el-table-column>
                <el-table-column prop="Books_Category"   label="图书分类"  width="120">
                </el-table-column>
                <el-table-column prop="Books_Price"   label="价格"  width="120">
                </el-table-column>
                <el-table-column  prop="borrow" label="可借阅"  width="120">
                </el-table-column>
                <el-table-column  label="操作" width="120">
                    <template slot-scope="scope">

                        <el-button  type="text" @click="">同意</el-button>
                        <el-button  type="text" @click="">拒绝</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </template>

   <!--     <el-form-item>
            <el-button type="primary" @click="resetForm('ruleForm')" round>éç½®</el-button>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <el-button @click="submitForm('ruleForm')" type="primary" round>æäº¤</el-button>
        </el-form-item>-->
    </el-form>
</div>
<script>
new Vue({
    el: '#app,#reader',
    data: function () {
        var userNumber= (rule, value, callback) => {
            var reg2 = /^A[0-9]{5}$/;
            if (!reg2.test(value)){
                return callback(new Error('您输入的工号格式不对！（如 A12765）'))
            }else{
                callback();
            }
        };
        var userName = (rule, value, callback) => {
            var reg3 = /^([\u4e00-\u9fa5A-Za-z]){1,20}$/;
            if (!reg3.test(value)) {
                return callback(new Error('可输入中英文（1-20位）'))
            } else {
                callback();
            }
        };
         var phone = (rule, value, callback) => {
             var reg3 = /^1\d{10}$/;
             if (!reg3.test(value)) {
                 return callback(new Error('只能输入11位手机号码！'))
             } else {
                 callback();
             }
         };
        return {

            tableData3: [{
                ISBN_numbe: '978-7-302-28486-4',
                Books_Name: 'SQL Server 2008',
                Books_Author: '明日科技',
                Books_Version: '第1版',
                Books_Category: '数据库',
                Books_Price: '59.85',
                borrow:1
            }, {
                ISBN_numbe: '978-7-111-35889-3',
                Books_Name: '奇点临近',
                Books_Author: 'Ray Kurzweil',
                Books_Version: '第1版',
                Books_Category: '人工智能',
                Books_Price: '69.00',
                borrow:1
            }],
            input2: "",
            ruleForm: {
                userNumber: '',
                userDepart: '',
                userName: '',
                phone: '',
            },
            rules: {
                userNumber: [
                    {required: true,validator: userNumber, trigger: 'change'}
                ],
                userDepart: [
                    {required: true, message: '请选择所在部门', trigger: 'change'}
                ],
                userName: [
                    {required: true,validator: userName, trigger: 'blur'}
                ],
                phone: [
                    {required: true,validator: phone, trigger: 'blur'}
                ]
            }

        };
    },
    methods: {
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    alert('submit!');
                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
        },
        deleteRow(index, rows) {
            rows.splice(index, 1);
        },
        toggleSelection(rows) {
            if (rows) {
                rows.forEach(row => {
                    this.$refs.multipleTable.toggleRowSelection(row);
                });
            } else {
                this.$refs.multipleTable.clearSelection();
            }
        },
        handleSelectionChange(val) {
            this.multipleSelection = val;
        }
    }
})
</script>
</body>
</html>
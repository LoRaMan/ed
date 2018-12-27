<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>图书归还</title>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="./../pageED/css/element-ui-index.css">
    <!-- import Vue before Element -->
    <script src="./../pageED/js/vue.js"></script>
    <!-- 引入组件库 -->
    <script src="./../pageED/js/element-ui-index.js"></script>
    <style>
        #app{
            width: 100%;
            text-align: -webkit-center;
        }
        .el-select .el-input {
            width: 130px;
        }
        .el-input-group{
            border-spacing: 40px;
        }
        .el-input-group{
            width: 59%;
        }
        .input-with-select .el-input-group__prepend {
            background-color: #fff;
        }
        .el-table::before {
            left: 0;
            bottom: 0;
            width: 100%;
            height: 0;
        }
        .el-input__inner{
            width: 104%;
        }
        .el-table .cell{
            text-align: center;
            font-size: medium;
        }
        .el-button--mini, .el-button--small {
            font-size: medium;
        }
    </style>
</head>
<body >
<div id="app" >
    <div style="margin-top: 15px;">
        <el-input placeholder="请输入内容"  class="input-with-select">
            <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
    </div>
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
            <el-table-column  prop="userNumber" label="员工工号 "  width="120">
            </el-table-column>
            <el-table-column prop="userName"   label="真实姓名"  width="120">
            </el-table-column>
            <el-table-column prop="phone"   label="联系方式"  width="130">
            </el-table-column>
            <el-table-column prop="ISBN_numbe"   label="ISBN编号"  width="120">
            </el-table-column>
            <el-table-column prop="Books_Name"   label="图书名称"  width="120">
            </el-table-column>
<!--            <el-table-column prop="name"   label="ISBN编号"  width="120">
            </el-table-column>-->
            <el-table-column prop="borrowData"   label="借阅日期"  width="120">
            </el-table-column>
            <el-table-column prop="condition"   label="状态"  width="120">
            </el-table-column>
            <el-table-column  label="操作" width="120">
                <template slot-scope="scope">
                    <el-button  type="text" @click="">还书</el-button>
                    <!--<el-button @click.native.prevent="deleteRow(scope.$index, tableData3)" type="text" >删除</el-button>-->
                </template>
            </el-table-column>
            <el-table-column  prop="returnData" label="归还日期"  width="120">
            </el-table-column>
        </el-table>
  <!--      <div style="margin-top: 20px">
            <el-button @click="toggleSelection()">取消选择</el-button>
        </div>-->
    </template>
</div>
<script>
    new Vue({
        el: '#app',
        data:function () {
            return{
                tableData3: [{
                    userNumber: 'A12568',
                    userName: '郭雅乐',
                    phone: '15510525777',
                    ISBN_numbe: '1-2-3-3-4',
                    Books_Name: '康桥',
                    borrowData: '2018-10-11',
                    condition: '未还',
                    returnData:''
                }, {
                    userNumber: 'A12765',
                    userName: '郭乐',
                    phone: '15510525777',
                    ISBN_numbe: '1-2-7-8-9',
                    Books_Name: '面朝大海',
                    borrowData: '2018-10-11',
                    condition: '未还',
                    returnData:''
                }],
                multipleSelection: []
            }
        },
        methods: {

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
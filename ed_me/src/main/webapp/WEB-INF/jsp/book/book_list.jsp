<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>图书查询</title>
         <!-- 引入样式、组件库、VUE -->
         <%@ include file="/WEB-INF/jsp/public/repository.jspf" %>
        <style>
            #app{
                width: 100%;
                height: 700px;
                text-align:-webkit-center;
            }
            el-input-group{
                border-spacing: 40px;
            }
            el-input-group{
                width: 59%;
            }
            input-with-select el-input-group__prepend {
                background-color: #fff;
            }
            el-table{
                text-align: -webkit-center;
            }
            el-table::before {
                left: 0;
                bottom: 0;
                width: 80%;
                height: 0;
            }
            el-input__inner{
                width: 104%;
            }
            el-table cell{
                text-align: center;
                font-size: medium;
            }
            el-button--mini el-button--small {
                font-size: medium;
            }
        </style>
    </head>
    <body >
        <div id="app" >
            <div style="margin-top: 50px; padding-bottom: 20px; width: 500px;">
                <el-input placeholder="请输入内容" class="input-with-select">
                    <el-button slot="append" icon="el-icon-search"></el-button>
                </el-input>
            </div>
            <template>
                <el-table ref="multipleTable"
                        :data="tableData3"
                        tooltip-effect="dark"
                        style="width: 100%"
                        @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="55"></el-table-column>
                <el-table-column  prop="Book_name" label="书名"  width="150"></el-table-column>
                <el-table-column prop="Book_author"   label="作者"  width="100"></el-table-column>
                <el-table-column prop="Book_version"   label="版本"  width="100"></el-table-column>
                <el-table-column prop="ISBN_numbe"   label="ISBN编号"  width="100"></el-table-column>
                <el-table-column prop="Books_Price"   label="图书价格"  width="100"></el-table-column>
                <el-table-column prop="Books_Shelf"   label="书架"  width="120"></el-table-column>
                <el-table-column prop="Books_Amount"   label="总量"  width="100"></el-table-column>
                <el-table-column prop="borrowed"   label="已借阅"  width="100"></el-table-column>
                <el-table-column  prop="borrowable" label="可借阅"  width="100"></el-table-column>
                <el-table-column  label="操作" width="180">
                    <template slot-scope="scope">
                         <el-button  type="text" @click="">编辑</el-button>
                         <el-button @click.native.prevent="deleteRow(scope.$index, tableData3)" type="text" >删除</el-button>
                        <el-button  type="text" @click="">借阅</el-button>
                    </template>
                </el-table-column>
                </el-table>
                <div style="text-align: center;margin-top:20px;">
                    <el-pagination @size-change="handleSizeChange"
                            @current-change="handleCurrentChange"
                            :current-page="currentPage4"
                            :page-sizes="[5, 10, 20, 30]"
                            :page-size="pageSize"
                    　　　　layout="total, sizes, prev, pager, next, jumper"
                    　　　　:total="100">
                    </el-pagination>
                </div>
            </template>
        </div>
        <div class="el-pagination__editor"></div>
        <script>
        new Vue({
            el: '#app',
            data:function () {
                return{
                    tableData3: [{
                        Book_name: '康桥',
                        Book_author: '徐志摩',
                        Book_version: '第1版',
                        ISBN_numbe: '1-2-3-3-4',
                        Books_Price: '13.14',
                        Books_Shelf: '软件部',
                        Books_Amount: 1,
                        borrowed: '1',
                        borrowable: '0'
                    }, {
                        Book_name: '面朝大海',
                        Book_author: '海子',
                        Book_version: '第2版',
                        ISBN_numbe: '1-4-5-7-7',
                        Books_Price: '52.10',
                        Books_Shelf: '软件部',
                        Books_Amount: '2',
                        borrowed: 1,
                        borrowable: 1
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
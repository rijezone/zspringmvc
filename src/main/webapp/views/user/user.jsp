﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management</title>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript">
//<![CDATA[
    var editFlag = undefined;//设置一个编辑标记
	function initData() {
    $('#dg').datagrid({
        url: 'getUsersInJSON.do',
        iconCls: "icon-add",
        fit:true,
        fitColumns: true,//设置为true将自动使列适应表格宽度以防止出现水平滚动,false则自动匹配大小     
        idField: 'id', //标识列，一般设为id，可能会区分大小写，大家注意一下
        loadMsg: "正在努力为您加载数据", //加载数据时向用户展示的语句
        rownumbers: true, //显示行数 1，2，3，4...
        pagination: true, //显示最下端的分页工具栏
        pageSize: 10, //读取分页条数，即向后台读取数据时传过去的值
        pageList: [10, 20, 30], //可以调整每页显示的数据，即调整pageSize每次向后台请求数据时的数据
		singleSelect:true,
		queryParams: {
			queryName:"",
			createTime:""
		},
        columns: [[{
            field: 'userId',
            title: 'userId',
			hidden:true,
            width: 100
        },
        {
            field: 'userName',
            title: '姓名',
            width: 200
        },
        {
            field: 'userPass',
            title: 'userPass',
			hidden:true,
            width: 200
        },
        {
            field: 'userRole',
            title: '角色',
            width: 100,
            align: 'right',
            formatter:function(value,row,index){
            	if(value==1){
            		return "管理员";
            	}else{
            		
            	}
            }
        },
		{
            field: 'phone',
            title: '电话',
            width: 150,
            align: 'right'
        },
        {
            field: 'email',
            title: 'email',
            width: 200,
            align: 'right'
        },
        {
            field: 'userDept',
            title: '部门',
			width: 500,
			resizable:true,
            align: 'right'
        },
        {
            field: 'createTime',
            title: '新建时间',
			width: 100,
            align: 'right'
        },
        {
            field: 'updateTime',
            title: '更新时间',
			width: 100,
            align: 'right'
        }
        ]],
		//toolbar设置表格顶部的工具栏，以数组形式设置
        toolbar: [{ //在dategrid表单的头部添加按钮
            text: "新增",
            iconCls: "icon-add",
            handler: function() {
               /* if (editFlag != undefined) {
                    $("#dg").datagrid('endEdit', editFlag); //结束编辑，传入之前编辑的行
                }
                if (editFlag == undefined) { //防止同时打开过多添加行
                    $("#dg").datagrid('insertRow', { 
					            //在指定行添加数据，appendRow是在最后一行添加数据
                        index: 0, // 行数从0开始计算
                        row: {
                            userId: '',
                            userName: '请输入姓名',
                            userPass: '' 
                        }
                    });
                    $("#dg").datagrid('beginEdit', 0); //开启编辑并传入要编辑的行
                    editFlag = 0;
                }*/
				editFlag = "add";
				newUser();
            }
        },
        '-', { //'-'就是在两个按钮的中间加一个竖线分割，看着舒服
            text: "删除",
            iconCls: "icon-remove",
            handler: function() {
                //选中要删除的行
               // var rows = $("#dg").datagrid('getSelections');
                //if (rows.length > 0) { //选中几行的话触发事件
                //    $.message.confirm("提示", "您确定要删除这些数据吗？",
                //    function(res) { //提示是否删除
                 //       if (res) {
                  //          var codes = {};
                 //           for (var i = 0; i < rows.length; i++) {
                 //               codes.push(rows[i].code);
                  //          }
                   //         console.info(codes.join(',')); //拼接字符串并传递到后台处理数据，循环删除，成功后刷新datagrid
						                      
					  // }
                  //  });
                //}
				destroyUser(); 
            }
        },
        '-', {
            text: "修改",
            iconCls: "icon-edit",
            handler: function() {
                //选中一行进行编辑
                var rows = $("#dg").datagrid('getSelections');
                if (rows.length == 1) { //选中一行的话触发事件
                   /* if (editFlag != undefined) {
                        $("#dg").datagrid('endEdit', editFlag); //结束编辑，传入之前编辑的行
                    }
                    if (editFlag == undefined) {
                        var index = $("#dg").datagrid('getRowIndex', rows[0]); //获取选定行的索引
                        $("#dg").datagrid('beginEdit', index); //开启编辑并传入要编辑的行
                        editFlag = index;
                    }*/
					initEditUser();
					editFlag = "mod";
                }
            }
        },
        '-', {
            text: "撤销",
            iconCls: "icon-redo",
            hidden:true,
            handler: function() {
                editFlag = undefined;
                $("#dg").datagrid('rejectChanges');
				
            }
        },
        '-'],
        onAfterEdit: function(rowIndex, rowData, changes) { //在添加完毕endEdit，保存时触发
            console.info(rowData); //在火狐浏览器的控制台下可看到传递到后台的数据，这里我们就可以利用这些数据异步到后台添加，添加完成后，刷新datagrid
            editFlag = undefined; //重置
        },
        onDblClickCell: function(rowIndex, field, value) { //双击该行修改内容
            if (editFlag != undefined) {
                $("#dg").datagrid('endEdit', editFlag); //结束编辑，传入之前编辑的行
            }
            if (editFlag == undefined) {
                $("#dg").datagrid('beginEdit', rowIndex); //开启编辑并传入要编辑的行
                editFlag = rowIndex;
            }
        }
    });
}

	//点击查找按钮出发事件
	function searchFunc() {
		$("#dg").datagrid("load", sy.serializeObject($("#searchForm").form()));//将searchForm表单内的元素序列为对象传递到后台
		//这里介绍reload的使用，使用reload时，会默认记住当前页面，当点击查询时，如果我们查到的数据只有三条，我们每页显示10挑数据，当前页码是2，那么我们将无法在当前页面看到我们查询出的结果，只有将页面向前跳转才会看到，但是用load就不会出现这种情况
	}
	//点击清空按钮出发事件
	function clearSearch() {
		$("#dg").datagrid("load", {});//重新加载数据，无填写数据，向后台传递值则为空
		$("#searchForm").find("input").val("");//找到form表单下的所有input标签并清空
	}

	$(function () {
		/*扩展Editors的datetimebox方法*/
		$.extend($.fn.datagrid.defaults.editors, {
			datetimebox: {//为方法取名
					init: function (container, options) {
							var editor = $('<input />').appendTo(container);
							options.editable = false;//设置其不能手动输入
							editor.datetimebox(options);
							return editor;
						},
				getValue: function (target) {//取值
							return $(target).datetimebox('getValue');
						},
				setValue: function (target, value) {//设置值
							$(target).datetimebox('setValue', value);
						},
				  resize: function (target, width) {
							$(target).datetimebox('resize', width);
						},
				 destroy: function (target) {
							$(target).datetimebox('destroy');//销毁生成的panel
						}
			}
		});
	});

	var url;
    function newUser(){    
        $('#dlg').dialog('open').dialog('setTitle','新增用户');    
        $('#fm').form('clear');    
        url = 'userAdd.do';    
    }    
    function initEditUser(){    
        var row = $('#dg').datagrid('getSelected');    
        if (row){    
            $('#dlg').dialog('open').dialog('setTitle','Edit User');    
            $('#fm').form('load',row);    
            url = 'userMod.do'; 		
        }    
    }    
    function saveUser(){    
        $('#fm').form('submit',{    
            url: url, 
			dataType:"json",
            onSubmit: function(){    
                return $(this).form('validate');    
            },    
            success: function(result){    
                var result = eval('('+result+')'); 
                if (result.errorMsg){    
                    $.messager.show({    
                        title: 'Error',    
                        msg: result.errorMsg    
                    });    
                } else {    
                    $('#dlg').dialog('close');        // close the dialog    
                    $('#dg').datagrid('reload');    // reload the user data  
					$.messager.alert("保存信息", "保存成功", "info");					
                }    
            }    
        });    
    }    
    function destroyUser(){    
        var row = $('#dg').datagrid('getSelected');    
        if (row){    
            $.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){    
                if (r){    
                    $.post('userDel.do',{userId:row.userId},function(result){
						//var result = eval('('+result+')'); 
                        if (result.returnCode=='OK'){    
                            $('#dg').datagrid('reload');    // reload the user data   
							$.messager.alert("信息", "删除成功", "info");							
                        } else {    
                            $.messager.show({    // show error message    
                                title: 'Error',    
                                msg: result.errorMsg    
                            });    
                        }    
                    },'json');    
                }    
            });    
        }    
    }



var sy = $.extend({}, sy);/*定义一个全局变量*/  
 sy.serializeObject = function (form) { /*将form表单内的元素序列化为对象，扩展Jquery的一个方法*/
var o = {};
$.each(form.serializeArray(), function (index) {
if (o[this['name']]) {
o[this['name']] = o[this['name']] + "," + this['value'];
} else {
o[this['name']] = this['value'];
}
});
return o;
};
 	
 	
function myformatter(date){
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    var d = date.getDate();
    return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
function myparser(s){
    if (!s) return new Date();
    var ss = (s.split('-'));
    var y = parseInt(ss[0],10);
    var m = parseInt(ss[1],10);
    var d = parseInt(ss[2],10);
    if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
        return new Date(y,m-1,d);
    } else {
        return new Date();
    }
}

function showSelectPanel(url,title) {
	$('#deptSelectDlg').dialog('open').dialog("setTitle",
			""+title+"");
	var content = "<iframe scrolling='no' frameborder='0'  src='"+url+"' style='width:100%;height:100%;'></iframe>";
	$('#p').panel({
		content : content,
		onLoad : function() {
			//alert('loaded successfully');
		}
	});
}
function getDeptInfo(data){
	//alert(data[0].split("_")[1]);
	// $("#userDept").textbox("setValue",data[0]);
	 $("#userDept").val(data[0].split("_")[0]);
	 $("#userDeptName").textbox("setValue",data[0].split("_")[1]);
	 $('#deptSelectDlg').dialog('close'); 
}
$('#pp').pagination({
    total:2000,
    pageSize:10
});

//]]>	
</script>
 <style type="text/css">
        #fm{
            margin:0;
            padding:10px 30px;
        }
        .ftitle{
            font-size:14px;
            font-weight:bold;
            padding:5px 0;
            margin-bottom:10px;
            border-bottom:1px solid #ccc;
        }
        .fitem{
            margin-bottom:5px;
        }
        .fitem label{
            display:inline-block;
            width:80px;
        }
        .fitem input{
            width:160px;
        }
    </style>
</head>
<body onload="initData()">

	<div class="easyui-layout" fit="true" border="false">
		<!--由于查询需要输入条件，但是以toolbar的形式不好，所以我们在Layout框架的头部north中书写查询的相关信息-->
		<!-- 这里我们尽量使其展示的样式与toolbar的样式相似，所以我们先查找toolbar的样式，并复制过来-->
		<div data-options="region:'north',title:'高级查询'"
			style="height: 100px; background: #F4F4F4;">
			<form id="searchForm">
				<table>
					<tr>
						<th>用户姓名：</th>
						<td><input name="queryName" />
						</td>
					</tr>    
					 
					<tr>
						<th>创建开始时间：</th>
						<td><input class="easyui-datebox" editable="false"
							name="createTime"
							data-options="formatter:myformatter,parser:myparser" />
						</td>
						<!--由于datebox框架上面的数据必须是时间格式的，所以我们用editable="false"来禁止用户手动输入，以免报错-->
						<td><a class="easyui-linkbutton" href="javascript:void(0);"
							onclick="searchFunc();">查找</a>
						</td>
						<td><a class="easyui-linkbutton" href="javascript:void(0);"
							onclick="clearSearch();">清空</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',title:'列表',split:false" style="height:100%">
			<table id="dg">
			</table>
		</div>
    </div>
 <script type="text/javascript">
    </script>
    
	<div id="dlg" class="easyui-dialog" style="width:450px;height:400px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons" data-options="iconCls:'icon-save',resizable:true,modal:true">
        <div class="ftitle">User Information</div>
        <form id="fm" method="post" novalidate>
			<input type="hidden" name="userId"/>
            <div class="fitem">
                <label>用户名:</label>
                <input name="userName" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>密码:</label>
                <input name="userPass" class="easyui-textbox" required="true">
            </div>
		    <div class="fitem">
                <label>部门:</label>
                <input name="userDept" id="userDept" type="hidden"/>
                <input name="userDeptName" id="userDeptName" class="easyui-textbox" required="true" data-options="
          		   prompt: 'select a dept here!',
            		icons:[{
                  iconCls:'icon-search',
                  handler: function(e){
                   	 var v = $(e.data.target).textbox('getValue');
                  	 showSelectPanel('/zspringmvc/deptController/initSelectDept.do','部门选择');
                	}
            		}] ">
            </div>
			<div class="fitem">
                <label>角色:</label>
                <input name="userRole" class="easyui-textbox" required="true">
            </div>
            <div class="fitem">
                <label>电话:</label>
                <input name="phone" class="easyui-textbox">
            </div>
            <div class="fitem">
                <label>邮箱:</label>
                <input name="email" class="easyui-textbox" validType="email">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
    
    <div id="deptSelectDlg" class="easyui-dialog"
		style="width:750px;height:400px;overflow:hidden;" closed="true"
		buttons="#deptSelect-buttons"
		data-options="iconCls:'icon-save',resizable:true,modal:true">
		<div id="p" class="easyui-panel"
			style="height:400px;" data-options="border:false">
		</div>	
	</div>
	
	<div id="deptSelect-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="javascript:postSelections()" style="width:90px">Save</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#deptSelectDlg').dialog('close')"
			style="width:90px">Cancel</a>
	</div>
</body>
</html>
﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Department Management</title>
<link rel="stylesheet" type="text/css"
	href="../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript">
//<![CDATA[
    var editFlag = undefined;//设置一个编辑标记
	function initData() {
    $('#dg').datagrid({
        url: 'getDatasInJSON.do',
        iconCls: "icon-add",
        fit:true,
        fitColumns: true,//设置为true将自动使列适应表格宽度以防止出现水平滚动,false则自动匹配大小     
        idField: 'id', //标识列，一般设为id，可能会区分大小写，大家注意一下
        loadMsg: "正在努力为您加载数据", //加载数据时向用户展示的语句
        pagination: true, //显示最下端的分页工具栏
        rownumbers: true, //显示行数 1，2，3，4...
        pageSize: 10, //读取分页条数，即向后台读取数据时传过去的值
        pageList: [10, 20, 30], //可以调整每页显示的数据，即调整pageSize每次向后台请求数据时的数据
		singleSelect:true,
		queryParams: {
			queryName:""
		},
        columns: [[{
            field: 'id',
            title: 'id',
			hidden:true,
            width: 100
        },
        {
            field: 'funcBh',
            title: '功能编码',
            width: 200
        },
        {
            field: 'funcName',
            title: '功能名称',
            width: 200
        },
        {
            field: 'parentBh',
            title: '上级编码',
			//hidden:true,
            width: 200
        },
        {
            field: 'fdesc',
            title: '功能描述',
            width: 200,
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
				newFunc();
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
				destroyFunc(); 
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
					initEditFunc();
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
        '-', {
            text: "test",
            iconCls: "icon-redo",
            hidden:true,
            handler: function() {
            	showSelectPanel('initSelectDept.do','功能选择');
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
    function newFunc(){    
        $('#dlg').dialog('open').dialog('setTitle','New Func');    
        $('#fm').form('clear');    
        url = 'add.do';    
    }    
    function initEditFunc(){    
        var row = $('#dg').datagrid('getSelected');    
        if (row){    
            $('#dlg').dialog('open').dialog('setTitle','Edit Func');    
            $('#fm').form('load',row);    
            url = 'mod.do'; 		
        }    
    }    
    function save(){    
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
    function destroyFunc(){    
        var row = $('#dg').datagrid('getSelected');    
        if (row){    
            $.messager.confirm('Confirm','Are you sure you want to destroy this user?',function(r){    
                if (r){    
                    $.post('del.do',{funcId:row.id},function(result){
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
 	
 	

//]]>	
</script>
<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}

.fitem input {
	width: 160px;
}
</style>
<jsp:include page="/views/common/commonselect/commonSelect.html"></jsp:include>
</head>
<body onload="initData()">

	<div class="easyui-layout" fit="true" border="false">
		<!--由于查询需要输入条件，但是以toolbar的形式不好，所以我们在Layout框架的头部north中书写查询的相关信息-->
		<!-- 这里我们尽量使其展示的样式与toolbar的样式相似，所以我们先查找toolbar的样式，并复制过来-->
		<div data-options="region:'north',title:'高级查询',collapsible:false"
			style="height: 70px; background: #F4F4F4;">
			<form id="searchForm">
				<table>
					<tr>
						<th>功能名称：</th>
						<td><input name="queryName" /></td>					
						<td><a class="easyui-linkbutton" href="javascript:void(0);"
							onclick="searchFunc();">查找</a></td>
						<td><a class="easyui-linkbutton" href="javascript:void(0);"
							onclick="clearSearch();">清空</a></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',title:'列表',split:false" style="height:100%">
			<table id="dg">
			</table>
		</div>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width:450px;height:400px;padding:10px 20px" closed="true"
		buttons="#dlg-buttons"
		data-options="iconCls:'icon-save',resizable:true,modal:true">
		<div class="ftitle">Func Information</div>
		<form id="fm" method="post" novalidate>
		 	<input name="id" type="hidden"/>
			<div class="fitem">
				<label>功能编码:</label> <input name="funcBh" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>功能名称:</label> <input name="funcName" class="easyui-textbox"
					required="true">
			</div>
			<div class="fitem">
				<label>上级功能:</label> <input name="parentBh" class="easyui-textbox">
				 <input name="pNo" type="hidden"/>
			</div>
			<div class="fitem">
				<label>功能描述:</label> <input name="fdesc" class="easyui-textbox"
					required="true">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton c6"
			iconCls="icon-ok" onclick="save()" style="width:90px">Save</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton"
			iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')"
			style="width:90px">Cancel</a>
	</div>

</body>
</html>
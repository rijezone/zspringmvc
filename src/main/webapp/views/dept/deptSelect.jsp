<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Department Select</title>
<link rel="stylesheet" type="text/css"
	href="../themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript">
//<![CDATA[
    var editFlag = undefined;//设置一个编辑标记
    var multiSelect = false;
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
		singleSelect:false,
		queryParams: {
			queryName:""
		},
        columns: [[{
            field: 'id',
            title: 'id',
			hidden:true
        },
        {
            field: 'deptNo',
            title: '部门编码',
            width: 100
        },
        {
            field: 'deptName',
            title: '部门名称',
            width: 200
        },
        {
            field: 'pNo',
            title: '上级编码',
			hidden:true
        },
        {
            field: 'deptDesc',
            title: '部门描述',
            width: 100,
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
            text: "确定",
            iconCls: "icon-ok",
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
				postSelections();
            }
        },
        '-']
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

	var sy = $.extend({}, sy);/*定义一个全局变量*/
	sy.serializeObject = function(form) { /*将form表单内的元素序列化为对象，扩展Jquery的一个方法*/
		var o = {};
		$.each(form.serializeArray(), function(index) {
			if (o[this['name']]) {
				o[this['name']] = o[this['name']] + "," + this['value'];
			} else {
				o[this['name']] = this['value'];
			}
		});
		return o;
	};

	function myformatter(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
				+ (d < 10 ? ('0' + d) : d);
	}
	function myparser(s) {
		if (!s)
			return new Date();
		var ss = (s.split('-'));
		var y = parseInt(ss[0], 10);
		var m = parseInt(ss[1], 10);
		var d = parseInt(ss[2], 10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
			return new Date(y, m - 1, d);
		} else {
			return new Date();
		}
	}
	
	function postSelections() {
		var rows = $("#dg").datagrid('getSelections');
		//alert(document.getElementsById("dg").innerHTML());
		if (rows.length > 0) { //选中几行的话触发事件
			var codes = new Array();
			for ( var i = 0; i < rows.length; i++) {
				codes.push(rows[i].deptCode+"_"+rows[i].deptName);
			}
			parent.getDeptInfo(codes);
		}
	}
	//
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
</head>
<body onload="initData()">

	<div class="easyui-layout" fit="true" border="false">
		<div data-options="region:'north',title:'',collapsible:false"
			style="height: 80px; background: #F4F4F4;padding-top:10px;">
			<form id="searchForm">
				<table>
					<tr>
						<th>部门名称：</th>
						<td><input name="queryName" /></td>
					</tr>
					<tr>
						<th>创建开始时间：</th>
						<td><input class="easyui-datebox" editable="false" name="createTime"
								data-options="formatter:myformatter,parser:myparser" /></td>
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

</body>
</html>
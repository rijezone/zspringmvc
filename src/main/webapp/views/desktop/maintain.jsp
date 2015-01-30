<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Dream Zone</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css">
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js" charset="UTF-8"></script>
<script type="text/javascript">
	window.onload = function() {
		//alert(window.screen.height);
		//alert(window.document.body.clientHeight);
		//alert(window.event.clientY);
	};

	// add a new tab panel
	function addTab1(menuurl) {
		$('#tt').tabs('add', {
			title : 'New Tab',
			content : 'Tab Body',
			href:'common.jsp?menuurl='+menuurl,
			closable : true
		});
	}

	var index = 0;
	function addPanel() {
		index++;
		$('#tt').tabs('add', {
			title : 'Tab' + index,
			content : '<div style="padding:10px">Content' + index + '</div>',
			closable : true
		});
	}
	function removePanel() {
		var tab = $('#tt').tabs('getSelected');
		if (tab) {
			var index = $('#tt').tabs('getTabIndex', tab);
			$('#tt').tabs('close', index);
		}
	}
	
	function addTab(title, href,icon){
		var tt = $('#tt');
		if (tt.tabs('exists', title)){//如果tab已经存在,则选中并刷新该tab    	
       		tt.tabs('select', title);
       	 	refreshTab({tabTitle:title,url:'<%=path%>/'+href});
	} else {
    	if (href){
	    	var content = '<iframe scrolling="no" frameborder="0"  src="<%=path%>/'+href+'" style="width:100%;height:100%;"></iframe>';
    	} else {
	    	var content = '未实现';
    	}
    	tt.tabs('add',{
	    	title:title,
	    	closable:true,
	    	content:content,
	    	iconCls:icon||'icon-default'
    	});
	}
}
/**    
 * 刷新tab
 * @cfg 
 *example: {tabTitle:'tabTitle',url:'refreshUrl'}
 *如果tabTitle为空，则默认刷新当前选中的tab
 *如果url为空，则默认以原来的url进行reload
 */
function refreshTab(cfg){
	var refresh_tab = cfg.tabTitle?$('#tt').tabs('getTab',cfg.tabTitle):$('#tt').tabs('getSelected');
	if(refresh_tab && refresh_tab.find('iframe').length > 0){
	var _refresh_ifram = refresh_tab.find('iframe')[0];
	var refresh_url = cfg.url?cfg.url:_refresh_ifram.src;
	//_refresh_ifram.src = refresh_url;
	_refresh_ifram.contentWindow.location.href=refresh_url;
	}
}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'',split:true,collapsible:false,href:''"
		style="height:150px;">
		<div id="cc"></div>
		<h2>Complex Layout</h2>
		<p>This sample shows how to create a complex layout.</p>
		<div style="margin:20px 0;"></div>
	</div>
	
	<div data-options="region:'west',title:'菜单导航',split:true"
		style="width:150px;">
		<div class="easyui-accordion" data-options="fit:true,border:false">
			<div title="系统管理" style="padding:10px;"
				data-options="selected:true">
				<a href="javascript:void(0);" onclick="addTab('用户管理','userController/initMain.do','a')">用户管理</a>
				<br>
				<a href="javascript:void(0);" onclick="addTab('部门管理','deptController/initMain.do','a')">部门管理</a>
				<br>
				<a href="javascript:void(0);" onclick="addTab('角色管理','roleController/initMain.do','a')">角色管理</a>
				<br>
				<a href="javascript:void(0);" onclick="addTab('日志管理','userLogController/initMain.do','a')">日志管理</a>
			</div>
			<div title="Title2" style="padding:10px;">content2</div>
			<div title="Title3" style="padding:10px">content3</div>
		</div>
	</div>
	
	<div data-options="region:'center',title:'工作区'"
		style="padding:5px;background:#eee;">
		<div id="tt" class="easyui-tabs"
			data-options="fit:true,border:false,plain:true">
			<div title="About" data-options="href:''"
				style="padding:10px"></div>
			<div title="DataGrid" style="padding:5px">
				<table class="easyui-datagrid"
					data-options="method:'get',singleSelect:true,fit:true,fitColumns:true">
					<thead>
						<tr>
							<th data-options="field:'itemid'" width="80">Item ID</th>
							<th data-options="field:'productid'" width="100">Product ID</th>
							<th data-options="field:'listprice',align:'right'" width="80">List
								Price</th>
							<th data-options="field:'unitcost',align:'right'" width="80">Unit
								Cost</th>
							<th data-options="field:'attr1'" width="150">Attribute</th>
							<th data-options="field:'status',align:'center'" width="50">Status</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
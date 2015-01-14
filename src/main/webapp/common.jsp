<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Complex Layout - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript">

	function initData(){
	alert("a");
	$('#dg').datagrid({
    url:'userController/getUsersInJSON.do',
    columns:[[
        {field:'userId',title:'Code',width:100},
        {field:'userName',title:'Name',width:100},
        {field:'userPass',title:'Price',width:100,align:'right'}
    ]]
});
	}
	$(document).ready(function(){
	alert("asdfasdf");
		initData();
	});
	function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
    }
</script>
</head>
<body onload="initData()">


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/index_work.css"/> 
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
<body>
	<h1>影视新增</h1>
	<form>
		电影名称:<input type="text" name="mname"><br/><br/>
		电影简介:<textarea rows="5" cols="30" name="introduction"></textarea><br/><br/>
		票价:<input type="text" name="price"><br/><br/>
		上映日期:<input type="date" name="startDate"><br/><br/>
		<div id="type"></div><br/>
		<input type="button" value="提交" onclick="add()">
	</form>
</body>
<script type="text/javascript">
	
	$.post(
		"<%=request.getContextPath()%>/queryTypeList",
		function(data){
			if (data != null) {
				var str = "电影类型:";
				for ( var i in data) {
					str += "<input type='checkbox' name='tid' value='"+data[i].tid+"'>"+data[i].tname;
				}
				$("#type").html(str);
			}
		},
		"json"
	)
	
	function add(){
		$.post(
			"<%=request.getContextPath()%>/add",
			$("form").serialize(),
			function(data){
				if (data > 0) {
					alert("添加成功!");
					location.href = "<%=request.getContextPath()%>/list";
				} else {
					alert("添加失败!");
				}
			},
			"json"
		)
	}
	
	
	

</script>
</html>
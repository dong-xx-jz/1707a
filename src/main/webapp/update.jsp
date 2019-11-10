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
	<h1>影视修改</h1>
	<form>
		<input type="hidden" name="mid" value="${m.mid }">
		电影名称:<input type="text" name="mname" value="${m.mname }"><br/><br/>
		电影简介:<textarea rows="5" cols="30" name="introduction">${m.introduction }</textarea><br/><br/>
		票价:<input type="text" name="price" value="${m.price }"><br/><br/>
		上映日期:<input type="date" name="startDate" value="${m.startDate }"><br/><br/>
		电影类型:<c:forEach  items="${list }" var="t">
					<input type="checkbox" name="tid" <c:if test="${t.flag }">checked="checked"</c:if> value="${t.tid }">${t.tname }
		</c:forEach></div><br/>
		<input type="button" value="修改" onclick="update()">
	</form>
</body>
<script type="text/javascript">
	
	
	function update(){
		$.post(
			"<%=request.getContextPath()%>/update",
			$("form").serialize(),
			function(data){
				if (data > 0) {
					alert("修改成功!");
					location.href = "<%=request.getContextPath()%>/list";
				} else {
					alert("修改失败!");
				}
			},
			"json"
		)
	}
	
	
	

</script>
</html>
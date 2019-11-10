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
	<a href="add.jsp"><input type="button" value="添加新影视"></a>
	<table>
		<tr>
			<th>选择</th>
			<th>编号</th>
			<th>电影名称</th>
			<th>电影简介</th>
			<th>票价</th>
			<th>上映日期</th>
			<th>电影类型</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${page.list }" var="m">
		<tr>
			<td><input type="checkbox" class="mids" value="${m.mid }"></td>
			<td>${m.mid }</td>
			<td>${m.mname }</td>
			<td>${m.introduction }</td>
			<td>${m.price }</td>
			<td>${m.startDate }</td>
			<td>${m.tname }</td>
			<td><a href="<%=request.getContextPath()%>/queryMovieById?mid=${m.mid}"><input type="button" value="修改"></a></td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="8">
				<a href="?pageNum=1">首页</a>
				<a href="?pageNum=${page.pageNum-1 < 1 ? page.pageNum : page.pageNum-1 }">上一页</a>
				<a href="?pageNum=${page.pageNum+1 > page.pages ? page.pageNum : page.pageNum+1 }">下一页</a>
				<a href="?pageNum=${page.pages }">尾页</a>
				共${page.pageNum }/${page.pages }页
			</td>
		</tr>
	</table>
</body>
</html>
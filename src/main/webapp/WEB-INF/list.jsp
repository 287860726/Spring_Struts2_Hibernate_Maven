<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>列表页面</title>
</head>
<body>
	<table border="1" width="200px" height="200px" align="center">
		<tr>
			<td>
				<a href="<%=basePath%>author/authorAction_getAllUser.action">用户</a>
			</td>
		</tr>
		<tr>
			<td>
				<a href="<%=basePath%>book/bookAction_getAllBook.action">书</a>
			</td>
		</tr>
		<tr>
			<td>
				<a href="<%=basePath%>book/bookAction_AddBook.action">添加一本图书</a>
			</td>
		</tr>
<!-- 		<tr> -->
<!-- 			<td> -->
<%-- 				<a href="<%=basePath%>book/bookAction_AddMoreBook.action">添加多本图书</a> --%>
<!-- 			</td> -->
<!-- 		</tr> -->
	</table>
</body>
</html>
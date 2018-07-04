<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试页面</title>
<script type="text/javascript">
	function gohome(){
		window.location.href = "<%=basePath %>list/listAction_getList.action";		
	}
</script>
</head>
<body>
	<button id="gohome" onclick="gohome()">返回主页</button>
	<table align="center" border="1px" width="500px">
		<th colspan="3">用户列表</th>
		<c:forEach var="user" varStatus="i" items="${users}">
			<tr align="center">
<%-- 				<td>${i.index+1}</td> --%>
				<td>${user.id}</td>
				<td>${user.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
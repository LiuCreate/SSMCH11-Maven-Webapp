<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<table border="1">
		<tr>
			<th>id</th>
			<th>登陆名</th>
			<th>用户名</th>
			<th>密码</th>
			<th>性别</th>
			<th>出生日期</th>
			<th>电话</th>
			<th>地址</th>
		</tr>
		<c:forEach var="user" items="${userList }">
			<tr>
				<td>${user.id }</td>
				<td>${user.userCode }</td>
				<td>${user.userName }</td>
				<td>${user.userPassword }</td>
				<c:if test="${user.gender==1 }">
					<td>女</td>
				</c:if>
				<c:if test="${user.gender==2 }">
					<td>男</td>
				</c:if>
				<td><fmt:formatDate value="${user.birthday }" type="date" pattern="yyyy-HH-dd "/></td>
				<td>${user.phone }</td>
				<td>${user.address }</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>

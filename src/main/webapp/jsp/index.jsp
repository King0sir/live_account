<%--
  Created by IntelliJ IDEA.
  User: kingsir
  Date: 16-9-8
  Time: 下午3:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>显示基本信息</title>
</head>
<body>
<table>
    <tr>
        <td>用户ID</td>
        <td>用户名</td>
        <td>用户生日</td>
        <td>工资</td>
    </tr>
    <%--遍历lstUsers集合中的User对象 --%>
    <c:forEach var="user" items="${lstUsers}">
        <tr>
            <td>${user.userId}</td>
            <td>${user.userName}</td>
            <td>${user.userBirthday}</td>
            <td>${user.userSalary}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

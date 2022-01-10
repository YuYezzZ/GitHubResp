<%--
  Created by IntelliJ IDEA.
  User: Mr.Wu
  Date: 2022/1/10
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>添加用户信息</h1>
<form action="${pageContext.request.contextPath}/account/save" method="post">
    账户名称<input type="text" name="name">
    账户金额<input type="text" name="money">
    <input type="submit" value="submit">
</form>
</body>
</html>

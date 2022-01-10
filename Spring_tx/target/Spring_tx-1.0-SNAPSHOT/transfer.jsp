<%--
  Created by IntelliJ IDEA.
  User: Mr.Wu
  Date: 2022/1/10
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/account/transfer" method="post">
    转出账户<input type="text" name="outMan">
    转入账户<input type="text" name="inMan">
    转账金额<input type="text" name="money">
    <input type="submit" value="submit">
</form>
</body>
</html>

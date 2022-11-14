<%--
  Created by IntelliJ IDEA.
  User: QJW
  Date: 2022/6/19
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    request.setAttribute("t1","hello");
%>
<html>
<head>
    <title>Title</title>
</head>
<jsp:forward page="t2.jsp"/>
<body>

</body>
</html>

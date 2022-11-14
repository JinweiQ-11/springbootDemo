<%--
  Created by IntelliJ IDEA.
  User: QJW
  Date: 2022/6/19
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String input = (String) request.getAttribute("t1");
    String sessid = session.getId();
%>>
<html>
<head>
    <title>Title</title>

    <h2><%=input%> </h2>
    <h2><%=sessid%> </h2>
    <h2>${t1} </h2>

</head>
<body>

</body>
</html>

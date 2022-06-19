<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--<html lang="zh" xmlns:th="http://www.thymeleaf.org">--%>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<h1>这是一个标题</h1>
<h2>这是一个标题</h2>
<h3>这是一个标题</h3>
<a href="https://www.baidu.com/">访问百度</a>
<form>
    <table border="1">
        <tr>
            <td>编号</td>
            <td>用户名</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.id}"></c:out></td>
                <td><c:out value="${user.name}"></c:out></td>
            </tr>
        </c:forEach>
    </table>

</form>
</body>
</html>

<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
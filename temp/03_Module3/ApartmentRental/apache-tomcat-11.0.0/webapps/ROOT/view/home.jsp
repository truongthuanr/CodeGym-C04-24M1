<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tnguyen
  Date: 10/24/2024
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/static/css/home.css"/>">
</head>
<body>
<h1>Home Page</h1>
<div class="newnote">
    <div class="newnote-header">
        Thêm ghi chú
    </div>
    <div class="newnote-title">
        <div class="title-name">Tiêu đề</div>

        <div class="title-value">content</div>

    </div>
    <div class="newnote-content">
        <div class="content-name">Nội dung</div>
        <div class="content-value"></div>
    </div>


</div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Application with JSP</title>
</head>
<body>
    <div>
        <form action="/board/add" method="post">
            <input type="text" name="title" placeholder"제목" value="" />
            <input type="submit" value="전송" />
        </form>
    </div>
</body>
</html>
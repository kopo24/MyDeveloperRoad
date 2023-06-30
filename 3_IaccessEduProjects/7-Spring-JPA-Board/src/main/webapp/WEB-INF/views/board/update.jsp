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
        <form action="/board/update" method="post">
            <input type="hidden" name="id" value=${updateId} />
            <input type="text" name="title" placeholder=${updateTitle} value="" />
            <input type="submit" value="수정" />
        </form>
    </div>
</body>
</html>
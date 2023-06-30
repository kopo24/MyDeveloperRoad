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
        <form action="/board/remove" method="post">
            <input type="hidden" name="id" value=${removeId} />
            <input type="text" value="진짜로 삭제 하시겠습니까?" />
            <input type="submit" value="삭제" />
        </form>
    </div>
</body>
</html>
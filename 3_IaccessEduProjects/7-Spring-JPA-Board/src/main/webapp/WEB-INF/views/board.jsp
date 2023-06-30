<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.List" %>
<%@ page import="com.jpa.board.myBoard.entity.Board" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring Boot Application with JSP</title>
</head>
<body>
    자바 문법 사용은 &lt&#37&#61 &#37&gt 또는 &lt&#37 &#37&gt을 사용하고, Key-Value로 넘긴 값은 &#36&#123&#125로 사용할 수 있다.
    <br/>
    이거는 메소드핸들러에 붙은 @ModelAttribute를 통해 자동으로 MV에 입력된 Model입니다.
    <br/>
    <table border = "1">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th></th>
            <th></th>
        </tr>
            <%
                List<Board> boards = (List<Board>)request.getAttribute("maBoardList");
                for (Board board : boards) {
                    if (board.getIsHide().equals("N")) {
            %>
                        <tr>
                            <td><%= board.getId() %></td>
                            <td><%= board.getTitle() %></td>
                            <td>
                                <form action="/board/remove" method="get">
                                    <input type="hidden" name="id" value=<%= board.getId() %> />
                                    <input type="submit" value="삭제" />
                                </form>
                            </td>
                            <td>
                                <form action="/board/update " method="get">
                                    <input type="hidden" name="id" value=<%= board.getId() %> />
                                    <input type="hidden" name="title" value=<%= board.getTitle() %> />
                                    <input type="submit" value="수정" />
                                </form>
                            </td>
                        </tr>
            <%
                    }
                }
            %>
    </table>
</body>
</html>
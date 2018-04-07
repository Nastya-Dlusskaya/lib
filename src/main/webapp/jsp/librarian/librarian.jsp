<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.03.2018
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Librarian</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <link rel="stylesheet" href="/css/style-desktop.css" type="text/css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300" type="text/css">
</head>
<body>
<div id="wrapper">

    <jsp:include page="../header.jsp"/>
    <div>
        <jsp:include page="librarian_menu.jsp"/>
    </div>

    <section>
        <c:if test="${not empty orders}">
            <table border="1">
                <caption>${captionBook}</caption>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Reader</th>
                    <th>Book</th>
                    <c:if test="${captionBook eq 'Ordered book'}">
                        <th>Order Date</th>
                        <th>Hand out book</th>
                    </c:if>
                    <c:if test="${captionBook eq 'Returned book'}">
                        <th>Place</th>
                        <th>Planned return date</th>
                        <th>Take book</th>
                    </c:if>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td><c:out value="${order.id}"/></td>
                        <td><c:out value="${order.reader}"/></td>
                        <td><c:out value="${order.book}"/></td>
                        <c:if test="${captionBook eq 'Ordered book'}">
                            <th><c:out value="${order.orderDate}"/></th>
                            <th>
                                <c:if test="${order.book.amount > 0}">
                                    <a href="?command=hand&id=<c:out value="${order.id}"/>&idBook=<c:out value="${order.book.id}"/>&type=home">Home</a>
                                    <a href="?command=hand&id=<c:out value="${order.id}"/>&idBook=<c:out value="${order.book.id}"/>&type=hall">Library</a>
                                </c:if>
                            </th>
                        </c:if>
                        <c:if test="${captionBook eq 'Returned book'}">
                            <td><c:out value="${order.place}"/></td>
                            <th><c:out value="${order.plannedReturnDate}"/></th>
                            <th>
                                <a href="?command=return_book&id=<c:out value="${order.id}"/>&idBook=<c:out value="${order.book.id}"/>">Take
                                    book</a>
                            </th>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </c:if>
    </section>
</div>

<footer>
    <jsp:include page="../footer.jsp"/>
</footer>

</body>
</html>

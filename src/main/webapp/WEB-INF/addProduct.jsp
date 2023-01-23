<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
        crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
    <title>AddCategory</title>
</head>
<body>
    <h1 class="m-3"><c:out value="${category.name}"/></h1>
    <ul class="list-group d-inline-block">
        <c:forEach items="${category.products}" var="product">
            <li class="list-group-item"><c:out value="${product.name}"/></li>
        </c:forEach>
    </ul>
    <h2 class="m-5" >Add Products: </h2>

    <form:form class="d-inline-block" action="/category/${id}" method="post" modelAttribute="category">
        <form:select path="products" class="mb-3 form-select form-select" aria-label=".form-select example">
            <c:forEach items="${products}" var="product">
                <form:option value="${product.id}"><c:out value="${product.name}"/></form:option>
            </c:forEach>
        </form:select>
        <input type="submit" class="btn btn-primary" value="Add"/>
    </form:form>
    <div class="m-3">
        <a class="m-3" href="/">Dashboard</a> <a class="m-3" href="/product">Products</a>
    </div>
</body>
</html>
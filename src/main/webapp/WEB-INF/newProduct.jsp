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
    <title>Document</title>
</head>
<body>
    <h1>New Product</h1>
    <form:form class="d-inline-block" action="/product/new" method="post" modelAttribute="product">
        <div class="mb-3">
            <form:label path="name" class="form-label"> Name</form:label>
            <form:errors path="name"/>
            <form:input path="name" type="text" class="form-control"/>
        </div>
            <div class="mb-3">
            <form:label path="description" class="form-label"> description</form:label>
            <form:errors path="description"/>
            <form:input path="description" type="text" class="form-control"/>
            </div>
        <div class="mb-3">
            <form:label path="price" class="form-label">Price</form:label>
            <form:errors path="price"/>
            <form:input path="price" type="text" class="form-control"/>
            </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form:form>
    <a href="/">Dashboard</a>
</body>
</html>
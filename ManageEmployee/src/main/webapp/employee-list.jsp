<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
  <style>
    .header1{
      width: 100px;
      height: 100px;
      background-color: aquamarine;
      color: white;
    }
  </style>
  <title>Employee Management Application</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

  <header class="header1">
    <h2>Manage Employee</h2>

    <a href="create.jsp" style="float: right;">Add New Employee</a>
  </header>
  <table class="table">
    <thead>
      <tr>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Phone</th>
        <th></th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="items" items="${requestScope.employees}">
      <tr>
        <td>${items.name}</td>
        <td>${items.email}</td>
        <td>${items.address}</td>
        <td>${items.phone}</td>
        <td><a href="update?id=<c:out value='${items.id}' />">Edit</a>
        <td><a href="delete?id=<c:out value='${items.id}' />">Delete</a>
      </tr>
    </c:forEach>


    </tbody>
  </table>

</body>

</html>
<%--
  Created by IntelliJ IDEA.
  User: lamt6
  Date: 27/05/2022
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form action="update" method="post">
  <div class="form-group">
    <label for="exampleInputName">Name</label>
    <input type="text" class="form-control" id="exampleInputName"  placeholder="Enter name">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail">Email</label>
    <input type="text" class="form-control" id="exampleInputEmail" placeholder="Enter Email">
  </div>
  <div class="form-group">
    <label for="exampleInputAddress">Address</label>
    <input type="text" class="form-control" id="exampleInputAddress" placeholder="Enter Address">
  </div>
  <div class="form-group">
    <label for="exampleInputPhone">Email</label>
    <input type="text" class="form-control" id="exampleInputPhone" placeholder="Enter Phone">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>

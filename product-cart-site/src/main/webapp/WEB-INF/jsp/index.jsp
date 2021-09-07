<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Product Administration</title>

<!-- Bootstrap CSS  & FontAwsome-->
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
<h5> List Of Products</h5>
<ul class="list-group list-group-horizontal">
  <li class="list-group-item"><a href="/add" class="list-group-item list-group-item-action list-group-item-warning">Add Product</a></li>
</ul>
<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Product Name</th>
      <th scope="col">Cost</th>
      <th scope="col">Description</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
  
  	<tr th:if="${products.empty}">
            <td colspan="4"> No Products Available </td>
    </tr>
    <tr th:each="product : ${products}">
            <th scope="row"><span th:text="${product.id}"></span></th>
            <td><span th:text="${product.name}"></span></td>
            <td><span th:text="${product.cost}"></span></td>
             <td><span th:text="${product.cost}"></span></td>
             <td><a th:href="@{'/edit/' + ${product.id}}" class="list-group-item list-group-item-action list-group-item-warning">Edit</a></td>
             <td><a th:href="@{'/delete/' + ${product.id}}" class="list-group-item list-group-item-action list-group-item-warning">Delete</a></td>
    </tr>
  </tbody>
</table>

</table>



	<!-- Bootstrap JS & jQuery -->
	
	<script  src="js/bootstrap.js"></script>
	
	<script  src="js/jquery-3.1.1.min.js"></script>



</body>
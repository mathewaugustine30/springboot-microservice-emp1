<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Add Product</title>

    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
</head>
<body>
<h5> Add Product 1</h5>


<form action="#" th:action="@{/save}" method="post" th:object="${product}">
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Product Name</label>
    <div class="col-sm-10">
      <input type="text" th:field="*{name}" class="form-control" id="name" placeholder="Name">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputEmail3"  class="col-sm-2 col-form-label">Description</label>
    <div class="col-sm-10">
      <input type="text" th:field="*{description}" class="form-control" id="description" placeholder="Description">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Cost</label>
    <div class="col-sm-10">
      <input type="text" th:field="*{cost}"class="form-control" id="cost" placeholder="Cost">
    </div>
  </div>

  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit"  class="btn btn-primary">Save</button>
    </div>
  </div>
</form>


        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>




</body>
</html>
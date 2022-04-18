<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>

<div class="container mt-4">

	<div class="row mt-4">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Num</th>
				<th>Title</th>
				<th>Writer</th>
				<th>Hit</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<th>${vo.num}</th>
					<th>${vo.title}</th>
					<th>${vo.writer}</th>
					<th>${vo.hit}</th>
					<th>${vo.regDate}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
	<div class="row mt-4">
      <form action="list" method="get" class="d-flex">
      <div class="co1-1">
		<select name="kind" class="form-select" aria-label="Default select example">
  			<option value="2" selected>검색조건</option>
  			<option value="1">제목</option>
  			<option value="2">내용</option>
  			<option value="3">작성자</option>
		</select>
		</div>
		<div class="co1-3">
        <input name="search" class="form-control me-2" type="search" placeholder="Search" aria-label="Search" value="${search}">
       </div>
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      <div class="row justify-content-end">
		<a href="./add" type="button" class="col-1 btn btn-outline-success ">Add</a>
	</div>
 
	</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
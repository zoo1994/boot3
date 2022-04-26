<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>

	<div class="container mt-4">

		<div class="row mt-4">
			<c:forEach items="${list}" var="vo">
				<div class="card" style="width: 18rem;">
					<img src="../resources/upload/product/${vo.filesVO[0].fileName}"
						class="card-img-top" alt="...">
					<div class="card-body">
						<ul class="list-group list-group-flush">
							<li class="list-group-item">Name : ${vo.productName}</li>
							<li class="list-group-item">Price : ${vo.productPrice}원</li>
							<li class="list-group-item">Count : ${vo.productCount}개</li>
							<li class="list-group-item">Detail : ${vo.productDetail}</li>
						</ul>

						<a href="#" class="btn btn-primary">자세히</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="justify-content-center">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link"
					href="./list?pageNum=${pager.pre?pager.startPageNum-1:pager.startPageNum}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
				<c:forEach begin="${pager.startPageNum}" end="${pager.lastPageNum}"
					var="i">
					<li class="page-item"><a class="page-link"
						href="./list?pageNum=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
				</c:forEach>
				<li class="page-item"><a class="page-link"
					href="./list?pageNum=${pager.next?pager.lastPageNum+1:pager.lastPageNum}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
			</ul>
		</nav>
	</div>
	<div class="row mt-4">
		<form action="list" method="get" class="d-flex">
			<div class="co1-1">
				<select name="kind" class="form-select"
					aria-label="Default select example">
					<option value="1" selected>검색조건</option>
					<option value="1">이름</option>
					<option value="2">내용</option>
				</select>
			</div>
			<div class="co1-3">
				<input name="search" class="form-control me-2" type="search"
					placeholder="Search" aria-label="Search" value="${search}">
			</div>
			<button class="btn btn-outline-success" type="submit">Search</button>
		</form>
		<div class="row justify-content-end">
			<a href="./add" type="button" class="col-1 btn btn-outline-success ">Add</a>
		</div>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
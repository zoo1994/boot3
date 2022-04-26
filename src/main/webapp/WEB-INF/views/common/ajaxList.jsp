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

	<div class="row mt-4">
		<table class="table table-hover">
			<tr>
				<td>Num</td>
				<td>Name</td>
				<td>Price</td>
				<td>Count</td>
			</tr>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.productNum}</td>
					<td>${vo.productName}</td>
					<td>${vo.productPrice}원</td>
					<td>${vo.productCount}개</td>
				</tr>
			</c:forEach>
		</table>
		<div class="justify-content-center">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link pager"
						href="#" data-pn="${pager.pre?pager.startPageNum-1:0}">Previous</a></li>
					<c:forEach begin="${pager.startPageNum}" end="${pager.lastPageNum}"
						var="i">
						<li class="page-item"><a class="page-link pageNumber" 
							href="#" data-value="${i}">${i}</a></li>
					</c:forEach>
					<li class="page-item"><a class="page-link pager" 
						href="#" data-pn="${pager.next?pager.lastPageNum+1:0}">Next</a></li>
				</ul>
			</nav>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
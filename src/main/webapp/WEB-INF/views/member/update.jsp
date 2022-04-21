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
			<div class="alert alert-primary" role="alert">
				<h4 class="text-center" style="text-transform: capitalize;">${board} update
					Page</h4>
			</div>
			<form action="./update" method="post" enctype="multipart/form-data">
				<div class="row mt-4">
					<div class="mb-3">
					<div class="mb-3">
						<label for="exampleFormControlInput2" class="form-label">email
						</label> <input type="text" name="email" class="form-control"
							id="exampleFormControlInput2">
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput2" class="form-label">phone
						</label> <input type="text" name="phone" class="form-control"
							id="exampleFormControlInput2">
					</div>

				</div>
				
		</div>

		<div class="row justify-content-end">
			<button type="submit" class="col-1 btn btn-outline-success">수정</button>
		</div>
		</form>
	</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
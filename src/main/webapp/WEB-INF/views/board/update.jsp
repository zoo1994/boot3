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
				<h4 class="text-center" style="text-transform: capitalize;">update
					Page</h4>
			</div>
			<form action="./update" method="post" enctype="multipart/form-data">
				<input type="hidden" name="num" value="${vo.num}">
				<div class="row mt-4">
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Title
						</label> <input value="${vo.title}" type="text" name="title" class="form-control"
							id="exampleFormControlInput1">
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput2" class="form-label">Writer
						</label> <input type="text" name="writer" class="form-control"
							id="exampleFormControlInput2" readonly="readonly" value="${vo.writer}">
					</div>
					<div class="mb-3">
						<label for="exampleFormControlTextarea1" class="form-label">Contents</label>
						<textarea class="form-control" name="contents"
							id="exampleFormControlTextarea1" rows="3">${vo.contents}</textarea>
					</div>
				</div>
				      <input class="form-control form-control-lg" type="file" name="files">
            </div>
            <div class="mb-3">
            
               <input class="form-control form-control-lg" type="file" name="files">
            </div>
				<div class="row justify-content-end">
					<button type="submit" class="col-1 btn btn-outline-success">update</button>
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
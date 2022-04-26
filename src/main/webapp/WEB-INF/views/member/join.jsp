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
	<c:import url="../temp/header_script.jsp"></c:import>
	<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<h4 class="text-center" style="text-transform: capitalize;">${board}
					join Page</h4>
			</div>
			<form action="./join" method="post" enctype="multipart/form-data">
				<div class="row mt-4">
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">id
						</label> <input type="text" name="id" class="form-control"
							id="exampleFormControlInput1">
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput2" class="form-label">pw
						</label> <input type="password" name="pw" class="form-control"
							id="exampleFormControlInput2">
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput2" class="form-label">name
						</label> <input type="text" name="name" class="form-control"
							id="exampleFormControlInput3">
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput2" class="form-label">email
						</label> <input type="text" name="email" class="form-control"
							id="exampleFormControlInput4">
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput2" class="form-label">phone
						</label> <input type="text" name="phone" class="form-control"
							id="exampleFormControlInput5">
					</div>

				</div>
				<input class="form-control form-control-lg" type="file" name="files">

				<div class="mb-3">
					<input class="form-control form-control-lg" type="file"
						name="files">
				</div>
				<div class="row justify-content-end">
					<button type="submit" class="col-1 btn btn-outline-success">join</button>
				</div>
			</form>
		</div>
		<div class="">
			<div class="form-check">
				<input class="form-check-input" type="checkbox" value=""
					id="checkAll"> <label class="form-check-label"
					for="checkAll"> checkbox-All </label>
			</div>
			<div class="form-check">
				<input class="form-check-input ch" type="checkbox" value=""
					id="flexCheckChecked"> <label
					class="form-check-label" for="flexCheckChecked">
					checkbox1 </label>
			</div>
						<div class="form-check">
				<input class="form-check-input ch" type="checkbox" value=""
					id="flexCheckChecked1"> <label
					class="form-check-label" for="flexCheckChecked1">
					checkbox2 </label>
			</div>
						<div class="form-check">
				<input class="form-check-input ch" type="checkbox" value=""
					id="flexCheckChecked2"> <label
					class="form-check-label" for="flexCheckChecked2">
					checkbox3 </label>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$("#checkAll").click(function(){
		$(".ch").prop("checked",$("#checkAll").prop("checked"));
	});
	
	$(".ch").click(function(){
		let check = true;
		$(".ch").each(function(idx, item){
			if(!$(item).prop("checked")){
				check=false;
			}
		});
		$("#checkAll").prop("checked",check);
	});
		  
	</script>
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>
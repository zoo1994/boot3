<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:import url="../temp/header_script.jsp"></c:import>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>


<title>Insert title here</title>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>

	<div class="container mt-4">
		<div class="row mt-4">
			<div class="alert alert-primary" role="alert">
				<h4 class="text-center" style="text-transform: capitalize;">${board}update
					Page</h4>
			</div>
			<form action="./update" method="post" enctype="multipart/form-data">
				<input type="hidden" value="${vo.productNum}" name="productNum">
				<div class="row mt-4">
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Name
						</label> <input type="text" name="productName" class="form-control"
							id="productName" value="${vo.productName}">
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput2" class="form-label">Price
						</label> <input type="number" name="productPrice" class="form-control"
							id="productPrice" value="${vo.productPrice}">
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput2" class="form-label">Count
						</label> <input type="number" name="productCount" class="form-control"
							id="productCount" value="${vo.productCount}">
					</div>
					<div class="mb-3">
						<div class="form-check">
							<input class="form-check-input sale" name="productSale" type="radio"
								value="1" id="flexCheckDefault" ${vo.productSale eq 1 ? "checked":''}> <label
								class="form-check-label" for="flexCheckDefault"> 판매 </label>
						</div>
						<div class="form-check">
							<input class="form-check-input sale" name="productSale" type="radio"
								value="0" id="flexCheckChecked" ${vo.productSale eq 0 ? "checked":''}> <label
								class="form-check-label" for="flexCheckChecked"> 판매중지 </label>
						</div>
					</div>
					<div class="mb-3">
						<label for="exampleFormControlTextarea1" id="productDetail1"
							class="form-label"></label>
						<textarea class="form-control" name="productDetail"
							id="productDetail" rows="3"></textarea>
					</div>
				</div>
				<div id="fileResult"></div>
				<div>
					<button id="fileAdd" type="button"
						class="col-1 btn btn-outline-success">FileAdd</button>
				</div>
				
				<div>
					<c:forEach items="${vo.filesVO}" var="i">
						<h3>${i.oriName}<button type="button" class="del" data-num="${i.fileNum}" data-name="${i.fileName}">DELETE</button></h3>
					</c:forEach>
				</div>
				
				<div class="row justify-content-end">
					<button id="addBtn" type="submit"
						class="col-1 btn btn-outline-success">update</button>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript"src ="../js/summernote.js"></script> 
	<script type="text/javascript" src="../resources/js/fileAdd.js"></script>
	<script type="text/javascript">
		summernoteInit("productDetail","${vo.productDetail}");						
		fileAddInit(${vo.filesVO.size()});
		fileDeleteInit();
		</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>

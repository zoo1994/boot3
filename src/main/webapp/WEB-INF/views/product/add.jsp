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
				<h4 class="text-center" style="text-transform: capitalize;">${board}Add
					Page</h4>
			</div>

			<div class="row" id="list"></div>

			<form action="./add" method="post" enctype="multipart/form-data">
				<div class="row mt-4">
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Name
						</label> <input type="text" name="productName" class="form-control"
							id="productName">
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput2" class="form-label">Price
						</label> <input type="number" name="productPrice" class="form-control"
							id="productPrice">
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput2" class="form-label">Count
						</label> <input type="number" name="productCount" class="form-control"
							id="productCount">
					</div>
					<div class="mb-3">
						<div class="form-check">
							<input class="form-check-input sale" name="productSale" type="radio"
								value="1" id="flexCheckDefault"> <label
								class="form-check-label" for="flexCheckDefault"> 판매 </label>
						</div>
						<div class="form-check">
							<input class="form-check-input sale" name="productSale" type="radio"
								value="0" id="flexCheckChecked" checked> <label
								class="form-check-label" for="flexCheckChecked"> 판매중지 </label>
						</div>
					</div>
					<div class="mb-3">
						<label for="exampleFormControlTextarea1" id="productDetail"
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
				<div class="row justify-content-end">
					<button id="addBtn" type="button"
						class="col-1 btn btn-outline-success">Add</button>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function getList(pn) {
			$.ajax({
				type : "GET",
				url : "./ajaxList",
				data : {
					pageNum : pn,
					perPage : 5
				},
				success : function(data) {
					$("#list").html(data.trim());
				}
			});
		}
		getList(0);
		$("#list").click(function(event) {
			if($(event.target).attr("class")== "page-link pageNumber") {
				let pageNum=$(event.target).attr(
								"data-value");
				getList(pageNum);
			}
			if ($(event.target).attr("class")== "page-link pager") {
				let a=$(event.target).attr( "data-pn");
				if (a> 0) {
					getList(a); } } });
		$("#addBtn").click(function() { 
			let formData = new FormData();
			$(".files").each(function(idx, item) {
						if(item.files.length>0){ 
							formData.append("files", item.files[0]);
							}
						//console.log(idx); 
						// index번호 
						//console.log(item);
						//<input type="file" 
						//console.log(item.files); 
						//input 태그의 file리스트
				//console.log(item.files[0]); //file list중 첫번째 파일
				//console.log(item.files[0].name); //첫번째 파일의 이름
				//formData.apppend("파라미터값", 값)
				
			});
			let sale=0;
			$(".sale").each(function (idx,item){
				if($(item).prop("checked")){
					sale=$(item).val();
				}
			})
			formData.append("productName",$("#productName").val());
			formData.append("productPrice",$("#productPrice").val());
			formData.append("productCount",$("#productCount").val());
			formData.append("productDetail",$("#productDetail").summernote("code"));
			formData.append("productSale",sale);
			$.ajax({
				type : "POST",
				url : "./add",
				processData : false,
				contentType : false,
				data : formData ,
				success : function(data) {
					if (data.trim()== '1') {
						alert("상품등록 완료");
						getList();
						$("#productName").val("");
						$("#productPrice").val("");
						$("#productCount").val("");
						$("#productDetail").summernote("code", "")
					} else {
						alert("상품등록 실패");
					}
				},
				error :	function() {
					alert('실패');
				}
			})
		});

		$('#productDetail').summernote({
			height : 400
		});
		let v='<div class="mb-3"><input class="form-control form-control-lg files" type="file" name="files"><button  type="button" class="col-1 btn btn-outline-success delBtn">x</button></div>'
		let count=0; $("#fileAdd").click(function() {
			if (count> 4) { 
				alert("파일을 최대 5개"); 
				return; }
			count++;
			$("#fileResult").append(v); }); 
			$("#fileResult").on("click",".delBtn", function() {
				$(this).parent().remove();
				count--; });
		</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>

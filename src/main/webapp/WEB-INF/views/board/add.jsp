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
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

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
			<form action="./add" method="post" enctype="multipart/form-data">
				<div class="row mt-4">
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">Title
						</label> <input type="text" name="title" class="form-control"
							id="exampleFormControlInput1">
					</div>
					<div class="mb-3">
						<label for="exampleFormControlInput2" class="form-label">Writer
						</label> <input type="text" name="writer" class="form-control"
							id="exampleFormControlInput2">
					</div>
					<div class="mb-3">
						<label for="exampleFormControlTextarea1" class="form-label" id="content"></label>
						<textarea class="form-control" name="contents"
							id="contents" rows="3"></textarea>
					</div>
				</div>
		<div id="fileResult"></div>
		<div>
		<button id="fileAdd" type="button" class="col-1 btn btn-outline-success">FileAdd</button>
		</div>
		<div class="row justify-content-end">
			<button type="submit" class="col-1 btn btn-outline-success">Add</button>
		</div>
		</form>
		</div>
	</div>
	<script type="text/javascript">
		$('#contents').summernote({
			height:400,
			placeholder:'내용을 입력하세요',
			callbacks: {
				onImageUpload:function(files){
					//files upload한 이미지 파일객체
					let formData = new FormData();
					formData.append("files",files[0]);
					formData.append("productName",$("#productName").val());
					formData.append("productPrice",$("#productPrice").val());
					formData.append("productCount",$("#productCount").val());
					formData.append("productDetail",$("#productDetail").summernote("code"));
					// /board/suumerFileUpload
					$.ajax({
						type : "POST",
						url : "./summerFileUpload",
						processData : false,
						contentType : false,
						data : formData ,
						success : function(data) {
							$("#contents").summernote('editor.insertImage',data.trim());
						},
						error : function() {
							alert('등록실패');
						}
					});
				}, //onImageUpload끝
				onMediaDelete:function(files){
					let fileName=$(files[0]).attr("src");
					console.log(fileName);
					$.ajax({
						type:"GET",
						url:"./summerFileDelete",
						data:{
							fileName : fileName
						},
						succesc:function(data){
							console.log(data);
						}
					})
				}//onMediaDelete끝
			}
		});
		let v = '<div class="mb-3"><input class="form-control form-control-lg" type="file" name="files"><button  type="button" class="col-1 btn btn-outline-success delBtn">x</button></div>'
		let count = 0;
		$("#fileAdd").click(function(){
			if(count>4){
				alert("파일을 최대 5개");
				return;
			}
			 count++;
			$("#fileResult").append(v);
		});
		$("#fileResult").on("click",".delBtn",function(){
			$(this).parent().remove();
			count--;
		});
		
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>

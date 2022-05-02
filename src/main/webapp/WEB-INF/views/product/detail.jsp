<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<form action="./delete" method="post">
<input type="hidden" name="productNum" value="${vo.productNum}">
<div class="card" style="width: 18rem;">
  <ul class="list-group list-group-flush">
    <li class="list-group-item">이름</li>
    <li class="list-group-item">${vo.productName}</li>
    <li class="list-group-item">가격</li>
    <li class="list-group-item">${vo.productPrice}</li>
    <li class="list-group-item">수량</li>
    <li class="list-group-item">${vo.productCount}</li>
    <li class="list-group-item">설명</li>
    <li class="list-group-item">${vo.productDetail}</li>
    <li class="list-group-item">판매여부</li>
    <li class="list-group-item">${vo.productSale}</li>
  </ul>
</div>
<div>
	<c:forEach items="${vo.filesVO}" var="i">
		<a href="./fileDown?fileNum=${i.fileNum}"><img src="../resources/upload/product/${i.fileName}" class="img-thumbnail" alt="..."></a>
	</c:forEach>
</div>
 <a href="./update?productNum=${vo.productNum}" type="button" class="col-1 btn btn-outline-success ">수정</a>
  <button class="btn btn-outline-success" type="submit">삭제</button>
  </form>

<div class="container">
	<h1><spring:message code="product.detail.info" arguments="${vo.productPrice},${vo.productCount}" argumentSeparator=","></spring:message> </h1>
</div>  
  
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>
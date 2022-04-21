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
<form action="./delete" method="post">
	<input name="id" type="hidden" value="${vo.id}">
<div class="card" style="width: 18rem;">
  <ul class="list-group list-group-flush">
    <li class="list-group-item">이름</li>
    <li class="list-group-item">${vo.name}</li>
    <li class="list-group-item">phone</li>
    <li class="list-group-item">${vo.phone}</li>
    <li class="list-group-item">email</li>
    <li class="list-group-item">${vo.email}</li>
  </ul>
</div>
<div>
	<c:forEach items="${vo.filesVOs}" var="i">
		<a href="./fileDown?fileNum=${i.fileNum}"><img src="../resources/upload/member/${i.fileName}" class="img-thumbnail" alt="..."></a>
	</c:forEach>
</div>
	<a href="./update?id=${vo.id}">수정</a>
  <button class="btn btn-outline-success" type="submit">회원탈퇴</button>
  </form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>
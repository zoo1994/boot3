<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="/board/list">Board</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="/product/list">Product</a>
        </li>
        <c:forEach items="${member.roleVOs}" var="i">
        	<c:if test="${i.roleName eq 'ROLE_SELLER'}">
        		<li class="nav-item">
          			<a class="nav-link active" href="/product/manage">Product 관리</a>
        		</li>
        	</c:if>
        </c:forEach>
                <c:forEach items="${member.roleVOs}" var="i">
        	<c:if test="${i.roleName eq 'ROLE_ADMIN'}">
        		<li class="nav-item">
          			<a class="nav-link active" href="/admin/manage">관리자 모드</a>
        		</li>
        	</c:if>
        </c:forEach>
        <c:choose>
        	<c:when test="${empty member}">
        		<li class="nav-item">
          			<a class="nav-link active" href="/member/join">Join</a>
        		</li>
        		<li class="nav-item">
          			<a class="nav-link active" href="/member/login">login</a>
        		</li>
        	</c:when>
			<c:otherwise>
				<li class="nav-item">
          			<a class="nav-link active" href="/member/logout">logout</a>
        		</li>
       			<li class="nav-item">
       				<a class="nav-link active" href="/member/myPage">Mypage</a>
        		</li>
			</c:otherwise>
        </c:choose>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled">Disabled</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
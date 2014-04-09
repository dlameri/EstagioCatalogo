<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
	<header id="main-header">
		<div class="container-header">
			<h1 class="logo"><a href="${pageContext.request.contextPath}">Ideais Electronics</a></h1>
			
			<div id="search-area">
				<form method="get" action="${pageContext.request.contextPath}/product/search" name="searchProduct">
					<div class="search-box">
						<input type="text" name="name" id="input-search-text">
						<input type="submit" value="Pesquisar" id="input-search-submit" class="search-icon">
					</div>
				</form>
			</div>
			
			<div class="login-or-register">
				<span>Olá, visitante!</span>
				<a href="">Cadastre-se</a>
				<a href="">Entre</a>
			</div>

			<nav id="main-nav" class="main-menu">
				<ul class="menu">
					<c:forEach items="${categories}"  var="category">
						<li class="menu-item"><a href="${pageContext.request.contextPath}/category/${category.id}/product">${category.name}</a>
							<ul class="sub-menu">
								<c:forEach items="${category.subcategories}" var="subcategory">
									<li class="submenu-item"><a href="../category/subcategory/${subcategory.id}">${subcategory.name}</a></li>
								</c:forEach>
							</ul>
						</li>
					</c:forEach>
				</ul>
			</nav>		
		</div>
	</header>
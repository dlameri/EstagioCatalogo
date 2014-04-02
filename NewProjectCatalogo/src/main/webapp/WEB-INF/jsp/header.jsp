<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header id="main-header">
	<div class="container">
		<h1 class="logo"><a href="">Ideais Electronics</a></h1>
		<div id="search-area">
			<div class="search-box">
				<input type="text" id="input-search-text">
				<input type="submit" value="Pesquisar" id="input-search-submit" class="search-icon">
			</div>
		</div>
		<div class="login-or-register">
			<span>Olá, visitante!</span>
			<a href="">Cadastre-se</a>
			<a href="">Entre</a>
		</div>
		<span class="shopping-cart">Carrinho</span>
		<nav class="main-menu">
			<ul class="menu">
				<c:forEach items="${categories}"  var="category">
					<li class="menu-item"><a href="./category/${category.id}">${category.name}</a>
						<ul class="sub-menu">
							<c:forEach items="${category.subcategories}"  var="subcategory">
								<li class="submenu-item"><a href="./category/subcategory/${subcategory.id}">${subcategory.name}</a></li>
							</c:forEach>
						</ul>
					</li>
				</c:forEach>
			</ul>
		</nav>
	</div>		
</header>

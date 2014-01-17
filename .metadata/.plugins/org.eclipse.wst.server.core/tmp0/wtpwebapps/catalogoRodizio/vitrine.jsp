<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Catálogo Project</title>

    <!-- Bootstrap core CSS -->
    <link href="Vitrine/dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="Vitrine/offcanvas.css" rel="stylesheet">

    <link href="Vitrine/dist/css/style.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <header>

  </header>

  <body>
    <div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.jsp">Catálogo Project</a>
        </div>
        <div class="collapse navbar-collapse">
        	<div id="comprado">
        		<p>${categoryName} ${message}</p>
        	</div>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->
    </div><!-- /.navbar -->

    <div class="container">

      <div class="jumbotron">
            <h1><img src="./images/logobolinha.png" id="logo">Estágio Ideais</h1>
            <h5><p>Vitrine de exposição e compra para avaliação no rodízio de equipes no Estágio Ideais 2013.</p></h5>
          </div>
      <div class="row row-offcanvas row-offcanvas-right">
        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar" role="navigation">
	        <div class="list-group">
	        	<a href="index.jsp" class="list-group-item active">TODAS AS LOJAS</a>
		        <s:iterator value="listCategories" var="category">
					<s:url var="url" action="findProductsByCategory">
						<s:param name="idCategory">
							<s:property value="id"/>
						</s:param>
					</s:url>
					<s:a href="%{url}" cssClass="list-group-item" >${category.name}</s:a>
				</s:iterator>
			</div>
        </div>        
        
        <div class="col-sm-9">
          <div class="row">
           		<s:iterator value="listProducts" var="product">
           			<div class="col-6 col-sm-6 col-lg-4">
	           			<figure>
							<s:url var="url" action=""><s:param name="id"/></s:url>
							<s:a href="#"><img src="${product.image.path}"></s:a>
							<figcaption><s:a>${product.name}</s:a></figcaption>
							<p><s>De: ${product.priceFromFormatado}</s></p>	
							<label>Por: ${product.priceForFormatado}</label>
							<p>Desconto de ${product.discount}</p>
							<p>12x de ${product.parcelamento}</p>
						</figure>
						<p><a class="btn btn-default" href="comprar.action?idProduct=${product.id}" role="button">Comprar</a></p>
            		</div><!--/span-->	
				</s:iterator>
          </div><!--/row-->
        </div><!--/span-->


      </div><!--/row-->

      <hr>

      <footer id="rodape">
        &copy; Uila & JotaJota Enterprises | Estagio 2013 Ideais Tecnologia.
      </footer>

    </div><!--/.container-->



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="Vitrine/dist/js/bootstrap.min.js"></script>
    <script src="Vitrine/offcanvas.js"></script>
    
    <!-- Javascript -->
    <script type="text/javascript" src="./js/vitrine.js"></script>
    
  </body>
</html>

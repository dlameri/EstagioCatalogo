<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">

	<head>
	    <title>Loja Virtual</title>
	    <link rel="stylesheet" type="text/css" href="css/style.css">
	    <meta charset = "utf-8">
	</head>
	<!--<s:include value="/header.jsp"></s:include>-->

<body>

    <div id="header">
        <div id="logotipo">
            <img id="logo" src="./images/icons/logo.png" alt="home">
            <h1>IDEAIS <br>
            ELETRONICS</h1> 
        </div>
        
        <div id="navegation">
            <h6> atendimento | meus produtos | minha conta </h6>
            <input type="text" value="Pesquisar" size="48"><input id="search_icon" type="image" alt="search submit" src="./images/icons/search_icon.png" height="22" width="22">
        </div>

        <img id="cart" src="./images/icons/cart.png" alt="cart">
    </div>
    
    <div id="menu">
       <h3> 
            DVDS e Blu-ray |
            Celulares |
            Informática |
            Eletroportáteis |
            TVs
        </h3>
    </div>
    
    <div id="contents">    
	    <table>	
	    	<tbody>
	    		<tr>
			    	<s:iterator value="listProducts" var="product">
						<td>
							<figure>
								<s:a action="productDetails"><img alt="foto pequena notebook HP" src="./images/products/notebook-hp-small.jpg"></s:a>
								<figcaption><s:a action="productDetails"><s:property value="name"/></s:a></figcaption>
							</figure>
						</td>
					</s:iterator>
	    		</tr>
	    	</tbody>
	    </table>
    </div>

</body>
</html>
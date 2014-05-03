var appContext;
var limitProducts;
var categoryProductsCounted;
var subcategoryProductsCounted;

$(function() {
	initializesGlobalVariables();

	$('.subcategory-item-nav').click( function(){

		var subcategoryId = $(this).data("subcategory-id");
		var url = getUrlSubcategoryTotalCount( subcategoryId );
		console.log(url);
		var count = requestResourceViaAjax( url );
		if( count != 0 ) {
			createPaginationToSubcategoryProducts( subcategoryId, count );
		}
	});
	
	if( categoryProductsCounted > 0 ) {
		var categoryId = $('#categoryId').val();
		createPaginationToCategoryProducts( categoryId, categoryProductsCounted );
	}
	
});

function createPaginationToCategoryProducts(categoryId, categoryProductsCounted) {
	urlCategoryProductsRequest = getUrlCategoryProductsPaginated( categoryId );
	createPagination( urlCategoryProductsRequest, limitProducts, categoryProductsCounted );
}

function createPaginationToSubcategoryProducts(subcategoryId, subcategoryProductsCounted) {
	urlSubcategoryProductsRequest = getUrlSubcategoryProductsPaginated( subcategoryId );
	createPagination( urlSubcategoryProductsRequest, limitProducts, subcategoryProductsCounted );
}

function getUrlCategoryProductsPaginated(categoryId) {
	return appContext+'/api/category/'+categoryId+'/paginatedProduct';
}

function getUrlSubcategoryTotalCount(subcategoryId) {
	return appContext+'/api/subcategory/'+subcategoryId+'/product/totalCounted';
}

function getUrlSubcategoryProductsPaginated(subcategoryId) {
	return appContext+'/api/subcategory/'+subcategoryId+'/paginatedProduct';
}

function createPagination( urlToSendRequest, limitProducts, countedProducts ) {
	$('.pagination').paging(countedProducts, {
		format: '[< ncnnnnnnn >]',
	 	perpage: limitProducts,
	 	lapping: 0,
	 	page: 1,

		onSelect: function (page) {
			var offset = (page -1) * limitProducts;
			var url = urlToSendRequest + '?maxResults=' + limitProducts + '&firstResult='+offset;
			requestProductsViaAjax(url);
		},
		onFormat: function (type) {
			switch (type) {
			case 'block':
				if (!this.active){
 					return '<span class="disabled">' + this.value + '</span>';
 				}else if (this.value != this.page) {
 					return '<a href="produtos/?page=' + this.value + '">' + this.value + '</a>';
 				}
 				return '<span class="current">' + this.value + '</span>';
			case 'next':
				if (this.active){
					return '<a href="produtos/?page=' + this.value + '" class="next">></a>';
				}
				return '<span class="disabled">></span>';
			case 'prev':
				if (this.active){
					return '<a href="produtos/?page=' + this.value + '" class="prev"><</a>';
				}
				return '<span class="disabled"><</span>';
			case 'first':
				if (this.active){
					return '<a href="produtos/?page=' + this.value + '" class="first"><<</a>';
				}
				return '<span class="disabled"><<</span>';
			case 'last':
				if (this.active){
					return '<a href="produtos/?page=' + this.value + '" class="last">>></a>';
				}
				return '<span class="disabled">>></span>';
 			case 'fill':
 				return "...";
			}
		}
	});
}

function requestResourceViaAjax( urlToSend ) {
	var response = 0;

	$.ajax({
		type : "GET",
		url : urlToSend,
		dataType : 'json',
		async:false,

		beforeSend : function() {
			console.log( 'Enviando dados para o servidor: ' + urlToSend );
			$( '.loading' ).show();
			
		},
		success: function( data ) {
			console.log( 'retornou '+data );
			response = data;
		},
		error: function( XMLHttpRequest, textStatus, errorThrown ) {
			alert( 'Erro ao executar a requisicao ajax de subcategoria' + errorThrown );
		},
		complete: function() {
			console.log( 'Encerrando requisicao ajax' );
			$( '.loading' ).hide();
		}
	});

	return response;
}

function requestProductsViaAjax( urlToSend ) {
	$.ajax({
		type : "GET",
		url : urlToSend,
		dataType : 'json',
		beforeSend : function() {
			console.log( 'Enviando dados para o servidor: ' + urlToSend );
			$( '.loading' ).show();
			$('.paginatedProducts').hide();
		},
		success: function( data ) {
			console.log( 'Retornou ' + data.length + ' produtos' );
			createProducts( data );
		},
		error: function( XMLHttpRequest, textStatus, errorThrown ) {
			alert( 'Erro ao executar a requisicao ajax' + errorThrown );
		},
		complete: function() {
			console.log( 'Encerrando requisicao ajax' );
			$( '.loading' ).hide();
			$( '.paginatedProducts' ).show();
			$( 'html, body' ).animate( { scrollTop: 0 }, 'slow' );
		}
	});
}

function createProducts( products ) {
	$('.paginatedProducts').empty();
	$.each(products, function(index) {
		$('.paginatedProducts').append('<li><article><header><a href="' + appContext + '/product/' + products[index].id + '"><img src="' + products[index].itemToDisplayOnShowcase.imageMain.showcaseUrl + '" alt="" class="product-main-image"></a></header><div class="product-information"><span class="product-name"><a href="' + appContext + '/product/'+ products[index].id +'">' + products[index].name + '</a></span><div class="product-price-box"><span class="price">De: ' + products[index].itemToDisplayOnShowcase.formattedPriceFrom + '</span> | <span class="price-sale">Por: ' + products[index].itemToDisplayOnShowcase.formattedPriceFor + '</span></div><span class="installment">ou em ' + getLastInstallment(products[index]) + '</span></div></article></li>');
	});
}

function getLastInstallment(product) {
	var lastInstallment = product.itemToDisplayOnShowcase.lastInstallment;
	return lastInstallment.number + 'x de ' + lastInstallment.value;
}

function initializesGlobalVariables(){
	limitProducts = 12;
	appContext = $('#context').val();
	categoryProductsCounted = $('#categoryProductsCounted').val();
	console.log('Contexto da aplicacao['+appContext+']');
	console.log('Total de produtos da categoria['+categoryProductsCounted+']');
}
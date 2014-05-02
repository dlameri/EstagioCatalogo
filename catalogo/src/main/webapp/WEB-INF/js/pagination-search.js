var appContext;
var limit;
var productsCounted;
var text;

$(function(){
	initializesGlobalVariables();

	console.log( 'Total de produtos da pesquisa['+productsCounted+']' );
	if( productsCounted > 0 ) {
		var url = getUrlSearchProductsPaginated( text );
		createPagination( url, limit, productsCounted );
	}
});

function createPagination( urlToSendRequest, limitProducts, countedProducts ) {
	$('.pagination').paging( countedProducts, {
		format: '[< ncnnnnnnn >]',
	 	perpage: limitProducts,
	 	lapping: 0,
	 	page: 1,

		onSelect: function ( page ) {
			var offset = (page -1) * limitProducts;
			var url = urlToSendRequest + '?maxResults=' + limitProducts + '&firstResult='+offset;
			requestProductsViaAjax( url );
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

function requestProductsViaAjax( urlToSend ) {
	$.ajax({
		type : "GET",
		url : urlToSend,
		dataType : 'json',
		beforeSend : function() {
			console.log( 'Enviando dados para o servidor: ' + urlToSend );
			$( '.loading' ).show();
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
			$( 'html, body' ).animate( { scrollTop: 0 }, 'slow' );
		}
	});
}

function createProducts( products ) {
	$( '.paginatedProducts' ).empty();
	$.each(products, function( index ) {
		$( '.paginatedProducts' ).append( '<li><article><header><a href="' + appContext + '/product/' + products[index].id + '"><img src="' + products[index].itemToDisplayOnShowcase.imageMain.showcaseUrl + '" alt="" class="product-main-image"></a></header><div class="product-information"><span class="product-name"><a href="' + appContext + '/product/'+ products[index].id +'">' + products[index].name + '</a></span><div class="product-price-box"><span class="price">De: ' + products[index].itemToDisplayOnShowcase.formattedPriceFrom + '</span><span class="price-sale">Por: ' + products[index].itemToDisplayOnShowcase.formattedPriceFor + '</span></div><span class="installment">ou em ' + getLastInstallment(products[index]) + '</span></div></article></li>' );
	});
}

function getUrlSearchProductsPaginated( textToSearch ) {
	return appContext+'/product/search/'+textToSearch+'/paginatedProduct';
}

function getLastInstallment(product) {
	var lastInstallment = product.itemToDisplayOnShowcase.lastInstallment;
	return lastInstallment.number + 'x de ' + lastInstallment.value;
}

function initializesGlobalVariables(){
	appContext = $( '#context' ).val();
	limit = 12;
	productsCounted = $( '#productsCounted' ).val();
	text = $( '#textToSearch' ).val();
	console.log( 'Contexto da aplicacao['+appContext+']' );
}
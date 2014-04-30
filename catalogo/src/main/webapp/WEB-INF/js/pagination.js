$(function() {
	// $('.subcategory-item-nav').click();
	createPagination();
});

/*function setRequestAjax(element) {
	url = '/category/'+categoryId+'/paginatedProduct?maxResults='+limit+'&firstResult='+offset;
	element.click( createPagination(url) );
};*/

function createPagination() {
	var totalCount = $('#count').val();
	var categoryId = $('#categoryId').val();
	var appContext = $('#context').val();
	var limit = 10;

	$('#pagination').paging(totalCount, {
		format: '[< ncnnn >]',
	 	perpage: limit,
	 	lapping: 1,
	 	page: 1,

		onSelect: function (page) {
			offset = (page -1) * limit;
			url = 'http://ideaiselectronics.com:8081/catalogo/category/'+categoryId+'/paginatedProduct?maxResults='+limit+'&firstResult='+offset;
			requestPage(url);
		},
		onFormat: function (type) {
			switch (type) {
			case 'block': // n and c
				return '<a>' + this.value + '</a>';
			case 'next':
				if (this.active){
					return '<a href="produtos/?page=' + this.value + '" class="next">></a>';
				}
				alert(this.value);
				return '<a>></a>';
			case 'prev': // <
				return '<a><</a>';
			case 'first': // [
				return '<a>first</a>';
			case 'last': // ]
				return '<a>last</a>';
			}
		}
	});
};


function requestPage(urlToSend) {			
	$.ajax({
		type : "GET",
		url : urlToSend,
		dataType : 'json',
		beforeSend : function() {
			console.log('Enviando dados para o servidor');
			console.log(urlToSend);
		},
		success: function(data) {
			console.log('Retornou ' + data[0].count + ' produtos');
			createProducts(data);
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			alert('Erro ao executar a requisicao ajax ' + errorThrown);
		},
		complete: function() {
			console.log('Encerrando requisicao ajax');	
		}
	});
};

function createProducts(data) {
	$('.paginatedProducts').empty();
	$.each(data, function(index) {
		$('.paginatedProducts').append(data[index].id + ' ');
	});
//		$('.paginatedProducts').append('
//			<li>
//				<article>
//					<header>
//						<a href="${pageContext.request.contextPath}/product/${'+data[index].id+'}"><img src="${product.itemToDisplayOnShowcase.imageMain.showcaseUrl}" alt="" class="product-main-image"></a>
//					</header>
//					<div class="product-information">
//						<span class="product-name"><a href="${pageContext.request.contextPath}/${product.id}">${product.name}</a></span>
//						<div class="product-price-box">
//							<span class="price">De: ${product.itemToDisplayOnShowcase.formattedPriceFrom}</span> | 
//							<span class="price-sale">Por: ${product.itemToDisplayOnShowcase.formattedPriceFor}</span>
//						</div>
//						<span class="installment">ou em ${product.itemToDisplayOnShowcase.lastInstallment}</span>
//					</div>
//				</article>
//			</li>
//			<li>Nome: <a href="productForm?id='+data[index].id+'">'+data[index].name+'</a></li>
//		');	
//	});
};
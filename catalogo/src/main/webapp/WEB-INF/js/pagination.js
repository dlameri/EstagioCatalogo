$(function() {
	//createPagination();
	
});

function createPagination() {
	var totalCount = ;
	var categoryId = $('#categoryId').val();
	var limit = 10;

	$('#pagination').paging(totalCount, {
		format: "[ < > ] . (qq -) nnncnnn (- pp)",
	 	perpage: limit,
	 	lapping: 1,
	 	page: 1,

		onSelect: function (page) {
			var offset = page -1;
			url = '/category/'+categoryId+'/paginatedProduct?maxResults='+limit+'&firstResult='+offset;
			requestPage();
		},
		onFormat: function (type) {
			switch (type) {
			case 'block': // n and c
				return '<a>' + this.value + '</a>';
			case 'next': // >
				return '<a>&gt;</a>';
			case 'prev': // <
				return '<a>&lt;</a>';
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
		beforeSend : console.log("Enviando dados para o servidor"),
		success : function(data) {
			createProducts(data);
		}
		
	});
};

function createProducts(data) {
	$.each(data, function(index) {
		$('.paginatedProducts').clear();
		$('.paginatedProducts').append('
			<li>
				<article>
					<header>
						<a href="${pageContext.request.contextPath}/product/${'+data[index].id+'}"><img src="${product.itemToDisplayOnShowcase.imageMain.showcaseUrl}" alt="" class="product-main-image"></a>
					</header>
					<div class="product-information">
						<span class="product-name"><a href="${pageContext.request.contextPath}/${product.id}">${product.name}</a></span>
						<div class="product-price-box">
							<span class="price">De: ${product.itemToDisplayOnShowcase.formattedPriceFrom}</span> | 
							<span class="price-sale">Por: ${product.itemToDisplayOnShowcase.formattedPriceFor}</span>
						</div>
						<span class="installment">ou em ${product.itemToDisplayOnShowcase.lastInstallment}</span>
					</div>
				</article>
			</li>
			<li>Nome: <a href="productForm?id='+data[index].id+'">'+data[index].name+'</a></li>
		');	
	});
};

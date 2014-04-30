$(function() {
	//createPagination();
	
});

function createPagination() {
	var totalCount = 1 ;
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
		$('.productsList').append('<li>Nome: <a href="productForm?id='+data[index].id+'">'+data[index].name+'</a></li>');	
	});
};

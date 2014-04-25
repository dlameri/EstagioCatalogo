$(function() {
	var urlToSend = "http://localhost:9082/Checkout/api/shoppingcart/totalQuantity";
		
	$.ajax({
		type : "GET",
		url : urlToSend,
		dataType : 'json',
		success : function(data) {
			$("#qtCart").append(data);
			
		}
		
	});
});
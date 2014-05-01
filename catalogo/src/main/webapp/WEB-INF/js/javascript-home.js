$(function(){
	setCarouselFeaturedProductsBehaviour();
	setCarouselTopSellersProductsBehaviour();
});

function setSearchAreaBehaviour() {
	$('.search-icon').click(function(){
		var search = $('.search-box');
		var logo = $('.logo a');

		if( logo.is(':visible') ){
			logo.fadeOut('slow', function(){
				var icon = $('.search-icon');
				icon.hide('fast');
				search.toggle('slow', function(){
					search.css('display','inline-block');
					icon.show('fast');
				});
			});
			return;			
		}
		search.toggle('slow', function(){
			logo.fadeIn('slow', function(){});
		});
		
	});
};

function setCarouselFeaturedProductsBehaviour() {
	$('.carousel-featured-products').bxSlider({
		// mode: 'fade', depois voltar com isso
		auto: true,
		autoHover: true,
		autoControls: false,
		tickerHover: true,
		speed: 750,
		pause: 3000
	});
}

function setCarouselTopSellersProductsBehaviour() {
	$('.carousel-top-sellers-products').bxSlider({
	  	pager: false,
	  	minSlides: 4,
	    maxSlides: 5,
	  	slideWidth: 250,
	    slideMargin: 10,
	    speed: 1900,
	    infiniteLoop: false
	});
}
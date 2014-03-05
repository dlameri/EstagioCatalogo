$(function(){
	setSearchAreaBehaviour();
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
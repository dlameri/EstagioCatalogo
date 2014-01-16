function back() {
	window.history.back();
};

window.onload = function() {
	var voltar = document.getElementById( 'linkVoltar' );
	voltar.onclick = back; 
	
};

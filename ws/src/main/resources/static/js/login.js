var images=new Array('img/background1.jpg','img/background2.jpg','img/background3.jpg');
var nextimage=0;
$(document).ready(function(){

	doSlideshow();
	
	$();
});


function doSlideshow(){
	if(nextimage>=images.length){nextimage=0;}
	$('body')
	.css('background-image','url("'+images[nextimage++]+'")')
	.fadeIn(3000,function(){
		setTimeout(doSlideshow,5000);
	});
}
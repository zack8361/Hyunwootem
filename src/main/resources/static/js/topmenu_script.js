$(document).ready(function(){
	$(".sh_nav").mouseenter(function(){
		$("#shGnb.main").addClass("on");
 		$("#shGnb.main .sh_logo img").attr("src","img/common/logo_m.png");
	 	$(".sh_lnb_s").fadeIn(200);
		$(".sh_lnb_bg").fadeIn(200);	
	}).mouseleave(function(){
		$("#shGnb.main").removeClass("on");
     	$("#shGnb.main .sh_logo img").attr("src","img/common/logo.png");
		$('.sh_lnb_s').stop().fadeOut(200);
	  	$('.sh_lnb_bg').stop().fadeOut(200);
	});
	$(window).on("scroll",function(){
        if($(window).scrollTop() > 50) { 
            $('#shGnb.main').addClass("blur");
        } else{
            $('#shGnb.main').removeClass("blur");
        }
        return false;
    });
});


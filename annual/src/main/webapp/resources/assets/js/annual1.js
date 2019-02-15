$(document).ready(function(){
	   $(".close-modal").click(function(){
		   $(".bigmodal").fadeOut();
	   });
	   $(".blocker").click(function(){
		   $(".bigmodal").fadeOut();
	   });
	   $("#name").click(function(){
		   $(".bigmodal").fadeIn();
	   });
	   $(".btn").click(function(){
		   var id=$(this).attr("id");
		   $("."+id).slideToggle();
	   });
});
function closed(){
	$(".bigmodal").fadeOut();
}
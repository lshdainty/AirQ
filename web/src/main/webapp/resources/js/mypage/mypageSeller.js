$(document).on('click','.reservation',function(){
	var index=$(".reservation").index(this);
	var member_id=$(".member_id:eq("+index+")").attr('id');
	
	window.open("/reservation?member_id="+member_id,"reservation","width=1100px, height=950px");
});

$(document).ready(function(){
	
	$.ajax({
		type:"POST",
		url:"/reviewList",
		dataType:"json",
		async:true,
		success:function(data){
			var html="";
			for(var i=0;i<data.length;i++){
				console.log(data[i].rownum);
				html+='<p>'+data[i].rownum+'</p>'
					+'<p>'+data[i].payment_code+'</p>'
					+'<p>'+data[i].payment_price+'</p>'
					+'<p>'+data[i].demand_code+'</p>'
					+'<p>'+data[i].tender_code+'</p>'
					+'<p>'+data[i].payment_date+'</p>';
			}
			$("#h1").append(html);
		}
	});
	
	$(document).on('click','#btn',function(){
		window.open('/reviewWrite','review',"width=570px, height=300px");
	});
});
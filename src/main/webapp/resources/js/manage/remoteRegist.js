/**
 * 
 */
function SelectValue(idvalue){
    var obj_id = document.getElementById('s_id');
    obj_id.value = idvalue;
}

function SelectValue2(idvalue2){
    var obj_id2 = document.getElementById('s_id2');
    obj_id2.value = idvalue2;
}

$(document).ready(function(){
	$("#btn-reg").click(function(){	// select value값 받아오기
		alert($("#selid option:selected").val())
		alert($("#selid2 option:selected").val())
		
		var query = {
			remote : $("#selid option:selected").val(),
			location : $("#selid2 option:selected").val()
		};
		
		$.ajax({
			type : "GET",
			url : "remoteReg",
			data : query,
			success : function(data){
				console.log(data);
//				var figure = '<figure>'
//					+'<div class="switch">'
//					+'<img class="boiler" src="resources/images/boiler.png" /><br/>'
//					+'<div class="local">보일러 원격제어 <br/>위치: 보일러실</div>'
//					+'<div class="on_off">'
//					+'<label class="rocker rocker-small">'
//					+'<input type="checkbox">'
//					+'<span class="switch-left">ON</span><span class="switch-right">OFF</span></label>'
//					+'<label class="rocker rocker-small">'
//					+'<input type="checkbox">'
//					+'<span class="switch-left">자동</span><span class="switch-right">수동</span></label>'
//					+'</div></div>'
				if(data == "boiler"){
					location.href="remoteMain";
//					$(".container2").append(figure);

				}
				
			}
		}); // ajax
	}); //btn-reg 클릭
	
	$("#btn-can").click(function(){
		location.href="remoteMain"
	}); //btn-can 클릭
});


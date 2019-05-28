/**
 * 
 */
//function SelectValue(idvalue){
//    var obj_id = document.getElementById('s_id');
//    obj_id.value = idvalue;
//}
//
//function SelectValue2(idvalue2){
//    var obj_id2 = document.getElementById('s_id2');
//    obj_id2.value = idvalue2;
//}

$(document).ready(function(){
	// 원격 제어 등록
	$("#btn-reg").click(function(){	// select value값 받아오기
		alert($("#nickname").val());
		alert($("#selid option:selected").val());
		alert($("#selid2 option:selected").val());
		
		var query = {
			alias : $("#nickname").val(),	
			remote : $("#selid option:selected").val(),
			location : $("#selid2 option:selected").val()
		};
		
		$.ajax({
			type : "GET",
			url : "remoteReg",
			data : query,
			success : function(data){
				console.log(data);

				location.href="remoteMain"
			}
		}); // ajax
	}); //btn-reg 클릭
	
	// 별명(닉네임) 중복 체크
	$("#btn-nickname").click(function(){
		alert($("#nickname").val())
		
		var query = {
				alias : $("#nickname").val()
		};
		
		$.ajax({
			asybc : false,
			type : "GET",
			url : "nicknameCheck",
			data : query,
			success : function(data){
				if(data == "No") { // 별명 중복 될 경우
					$(".re_container .msg").text("사용불가");
					$(".re_container .msg").attr("style", "color:#f00");
					
					$("#btn-reg").attr("disabled", "disabled");
				} else if(data == "Yes") {
					$(".re_container .msg").text("사용가능");
					$(".re_container .msg").attr("style", "color:#00f");
					
					$("#btn-reg").removeAttr("disabled");
				}
				
			}
		});
	});
	
	$("#btn-can").click(function(){
		location.href="remoteMain"
	}); //btn-can 클릭
});


////이용약관 동의
//    var doc = document; 
//    var form1 = doc.getElementById('form1'); 
//    var inputs = form1.getElementsByTagName('INPUT'); 
//    var form1_data = {
//      "cb": false, 
//    }; 
//    var c1 = doc.getElementById('cb'); 
//    function checkboxListener() {
//      form1_data[this.name] = this.checked; 
//      if(this.checked) {
//        // submit 할때 체크하지 않아 색이 변한 font 를 다시 원래 색으로 바꾸는 부분. 
//        this.parentNode.style.color = "#000"; 
//      }
//    }
//      c1.onclick = checkboxListener; 
//      var all = doc.getElementById('all'); 
//      all.onclick = function() {
//        if (this.checked) {
//          setCheckbox(form1_data, true); 
//        } else {
//          setCheckbox(form1_data, false); 
//        }
//      }; 
//      function setCheckbox(obj, state) {
//        for (var x in obj) {
//          obj[x] = state; 
//          for(var i = 0; i < inputs.length; i++) {
//            if(inputs[i].type == "checkbox") {
//              inputs[i].checked = state; 
//            }
//          }
//        }
//      } 
//      
//var value = $("select option:selected").val();  
//alert(value);
  
// 셀렉트 옵션에 따른 데이터 값 불러오기
$(document).ready(function(){
	$("#change") .click(function(){
		var query = {
				selected : $("select option:selected").val(),
		}
		$.ajax({
			type : "POST",
			data : query,
			url : "mypageMainPostsAjax",
			success : function(data){
				if(data == "0"){
					$(".form2").children().show();
					$(".form2").show();
					$(".form3").children().show();
					$(".form3").show();
					$(".form4").children().show();
					$(".form4").show();
				}else if(data == "pd"){
					console.log(".form2");
					$(".form2").children().show();
					$(".form2").show();
					$(".form3").children().hide();
					$(".form3").hide();
					$(".form4").children().hide();
					$(".form4").hide();
					
				}else if(data == "ps"){
					$(".form2").children().hide();
					$(".form2").hide();
					$(".form3").children().show();
					$(".form3").show();
					$(".form4").children().hide();
					$(".form4").hide();
				}else if(data =="td"){
					$(".form2").children().hide();
					$(".form2").hide();
					$(".form3").children().hide();
					$(".form3").hide();
					$(".form4").children().show();
					$(".form4").show();
				}
			}
		})
	});
});

//관리자 글 관리 상세페이지 시작
$(document).on('click','.form2',function(){
	var report_code = $(this).attr("id");
	console.log(report_code);
	window.location.href="/mypageMainPostsIn?report_code="+report_code;
});
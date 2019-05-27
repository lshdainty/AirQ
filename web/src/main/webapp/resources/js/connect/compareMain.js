$.ajax({
		type: "get",
		url: "http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admCodeList.json",
		data : {authkey : $('#sido_key').val()},
		async: false,
		dataType: 'json',
		success: function(data) {
			var html = "<option value='광역시/도'>광역시/도</option>";
		
			for(var i=0;i<data.admVOList.admVOList.length;i++){ 
				html +="<option value='"+data.admVOList.admVOList[i].lowestAdmCodeNm+"'>"+data.admVOList.admVOList[i].lowestAdmCodeNm+"</option>"
			}
			$('#sido_code').html(html);
		},
		error: function(xhr, stat, err) {}
});

$.ajax({
	type: "get",
	url: "/matterList",
	async: false,
	dataType: 'json',
	success: function(data) {
		console.log(data);
		var html = "<option value='측정 물질'>측정 물질</option>";
	
		for(var i=0;i<data.matterList.length;i++){ 
			html +="<option value='"+data.matterList[i].matter_code+"'>"+data.matterList[i].matter_name+"</option>"
		}
		$('#matter').html(html);
	},
	error: function(xhr, stat, err) {}
});

$(document).on("change","#sido_code",function(){
	var thisVal = $(this).val();
	
	$.ajax({
		type: "get",
		url: "/areasido",
		data : {area_do : thisVal},
		async: false,
		dataType: "json",
		success: function(data) {
			var html = "<option value='선택'>선택</option>";
			
			for(var i=0;i<data.aList.length;i++){
				html +="<option value='"+data.aList[i].area_si+"'>"+data.aList[i].area_si+"</option>"
    		}
            $('#sigoon_code').html(html);
		},
		error: function(xhr, stat, err) {}
	});
});

//정렬값 확인 함수 시작
function sortdata(){
	var sort = $(".option-active").attr("value");
	return sort
}
//정렬값 확인 함수 끝

//정렬 선택 시작
$('.category-option').click(function(){
    $(".option-active").removeClass("option-active");
    $('.compare-category').find(this).addClass("option-active");
    ajax(1,sortdata());
});
//정렬 선택 끝

//광역시/도 선택 시작
$("#sido_code").change(function(){
	ajax(1,sortdata());
});
//광역시/도 선택 선택 끝

//시/구 선택 시작
$("#sigoon_code").change(function(){
	ajax(1,sortdata());
});
//시/구 선택 선택 끝

//평수 선택 시작
$("#space").change(function(){
	ajax(1,sortdata());
});
//평수 선택 끝

//paging 시작
function page(idx){
	ajax(idx,sortdata());
}
//paging 끝

//ajax 함수 시작
function ajax(idx,sort){
	var data = {
		sido : $("#sido_code option:selected").val(),
		sigoon : $("#sigoon_code option:selected").val(),
		space : $("#space option:selected").val(),
		sort : sort
	}
	$.ajax({
		type: "get",
		url: "/selectCompare?pagenum="+idx,
		data : data,
		async: false,
		dataType: "json",
		success: function(data) {
			var result="";
			var space="";
			var page="";
			if(data.pList.length==0){
				alert("검색결과가 없습니다.");
			}else{
				for(var i=0; i<data.pList.length; i++){
					switch(data.pList[i].p_space){
						case 1: space="1~10평"; break;
						case 2: space="11~20평"; break;
						case 3: space="21~30평"; break;
						case 4: space="31~40평"; break;
						case 5: space="41~50평"; break;
						case 6: space="51~60평"; break;
						case 7: space="61~70평"; break;
						case 8: space="71~80평"; break;
						case 9: space="81~90평"; break;
						case 10: space="91~100평"; break;
						case 11: space="101평~"; break;
					}
					result += '<div class="compare-post" id="'+data.pList[i].product_code+'">';
					result += '<div class="compare-thumb"><img src="'+"resources/images/800490.png"+'" alt="이미지X"></div>'
					result += '<div class="compare-info"><div class="compare__title"><span>'+data.pList[i].product_name+'</span></div>'
					result += '<div class="compare__content">측정 적절 평수 : <span>'+space+'</span><br/>';
					result += '측정 지점 : <span>'+data.pList[i].measure_point+'</span><br/>';
					result += '만족도 평균 : <span>'+data.pList[i].staravg+'</span><br/>';
					result += '판매 건수 : <span>'+data.pList[i].sellnum+'</span><br/>';
					result += '측정 물질 : ';
					for(var j=0; j<data.pList[i].matterVO.length; j++){
						result += '<span>'+data.pList[i].matterVO[j].matter_name;
						if((j+1)!=data.pList[i].matterVO.length){
							result += ', ';
						}
						result += '</span>';
					}
					result += '<br/></div><div class="compare__price"><span>'+data.pList[i].product_price+'</span>원</div></div></div>'
					space="";
				}
				$(".compare-list").empty();
				$(".compare-list").append(result);
				if(data.criteria.prev){
					page += '<li class="page-item"><a class="page-link" href="javascript:page('+(data.criteria.startPage-1)+');" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>'
				}
				for(var i=data.criteria.startPage; i<=data.criteria.endPage; i++){
					page += '<li class="page-item"><a class="page-link" href="javascript:page('+i+');">'+i+'</a></li>'
				}
				if(data.criteria.next){
					page += '<li class="page-item"><a class="page-link" href="javascript:page('+(data.criteria.endPage+1)+');" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>'
				}
				$(".pagination").empty();
				$(".pagination").prepend(page);
				$("html, body").animate({ scrollTop: 0 }, 1);
			}	//else
		}	//success
	});	//ajax
}	//function
//ajax 함수 끝

//추천 상품 클릭시 상품 상세페이지 시작
$(".compare-recommand__post").click(function(){
	var product_code = $(this).attr("id");
	window.location.href="/product?product_code="+product_code;
});
//추천 상품 클릭시 상품 상세페이지 끝

//상품 상세페이지 시작
$(document).on('click','.compare-post',function(){
	var product_code = $(this).attr("id");
	window.location.href="/product?product_code="+product_code;
});
//상품 상세페이지 끝

//상품 등록페이지 시작
$("#productWrite").click(function(){
	window.location.href="/productWrite";
});
//상품 등록페이지 끝
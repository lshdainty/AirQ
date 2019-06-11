var ip = sessionStorage.getItem('IP_ADDRESS');
var user = JSON.parse(sessionStorage.getItem("user"));
var member_id = user.member_id;

//광역시/도 목록 가져오기
$.ajax({
	type: "get",
	url: "http://openapi.nsdi.go.kr/nsdi/eios/service/rest/AdmService/admCodeList.json",
	data : {authkey : "12685d425f1af0872d756c"},
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

//선택가능한 물질 목록 가져오기
$.ajax({
type: "get",
url: ip+"/m.matterList",
async: false,
dataType: 'json',
success: function(data) {
	var html = "<option value='측정 물질'>측정 물질</option>";

	for(var i=0;i<data.matterList.length;i++){ 
		html +="<option value='"+data.matterList[i].matter_code+"'>"+data.matterList[i].matter_name+"</option>"
	}
	$('#matter').html(html);
},
error: function(xhr, stat, err) {}
});

//사용자가 광역시/도를 선택했을때 광역시/도에 해당하는 시/구 목록 불러오기
$(document).on("change","#sido_code",function(){
	var thisVal = $(this).val();

	$.ajax({
		type: "get",
		url: ip+"/m.areasido",
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
	var sort = $("#sort option:selected").val();
	return sort
}
//정렬값 확인 함수 끝

//정렬값 선택 시작
$("#sort").change(function(){
	ajax(1,sortdata());
});
//정렬값 선택 끝

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

//물질 선택 시작
$("#matter").change(function(){
	ajax(1,sortdata());
});
//물질 선택 끝

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
		matter : $("#matter option:selected").val(),
		sort : sort
	}
	$.ajax({
		type: "get",
		url: ip+"/m.selectCompare?pagenum="+idx,
		data : data,
		async: false,
		dataType: "json",
		success: function(data) {
			var content="";
			var page="";
			if(data.pList.length==0){
				alert("검색결과가 없습니다.");
				$("#comparePosts").empty();
				$(".pagination").empty();
			}else{
				$(".pCount").text(data.criteria.totalcount);
				for(var i=0; i<data.pList.length; i++){
					content+= '<div class="connect-post">' + 
											'<div class="post-thumb">' + 
												'<img src="'+ip+'/resources/uploadFile/images/'+data.pList[i].file_name+'" alt="">' + 
											'</div>' + 
											'<div class="post-explain">' + 
												'<div class="post-title">'+data.pList[i].product_name+'</div>' + 
												'<div class="post-content">'+"판매수:"+data.pList[i].sellnum+", 만족도 평균:"+data.pList[i].staravg+'</div>' + 
												'<div class="post-price">'+data.pList[i].product_price+"원"+'</div>' + 
											'</div>' + 
										'</div>';
				}
				$("#comparePosts").empty();
				$("#comparePosts").append(content);
				if(data.criteria.prev){
					page += '<li class="page-item"><a class="page-link" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>'
				}
				for(var i=data.criteria.startPage; i<=data.criteria.endPage; i++){
					page += '<li class="page-item"><a class="page-link">'+i+'</a></li>'
				}
				if(data.criteria.next){
					page += '<li class="page-item"><a class="page-link" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>'
				}
				$(".pagination").empty();
				$(".pagination").prepend(page);
				$("html, body").animate({ scrollTop: 0 }, 1);
			}	//else
		}	//success
	});	//ajax
}	//function
//ajax 함수 끝
$(document).on('click','.page-item',function(){
	var pageNum = ($(this).text());
	ajax(pageNum,sortdata());
});
//추천 상품 클릭시 상품 상세페이지 시작
$(".compare-recommand__post").click(function(){
	var product_code = $(this).attr("id");
	//window.location.href="/product?product_code="+product_code;
});
//추천 상품 클릭시 상품 상세페이지 끝

//상품 상세페이지 시작
$(document).on('click','.compare-post',function(){
	var product_code = $(this).attr("id");
	//window.location.href="/product?product_code="+product_code;
});
//상품 상세페이지 끝

//상품 등록페이지 시작
$("#productWrite").click(function(){
	//window.location.href="/productWrite";
});
//상품 등록페이지 끝

//페이지 들어왔을때 상품리스트 가져오기
$(function(){
	var query = {
		member_id : member_id
	}
	$.ajax({
		type: "get",
		url: ip+"/m.compareMain",
		data : query,
		async: false,
		dataType: 'json',
		success: function(data) {
			console.log(data);
			var recommend = "";
			var content = "";
			var page = "";
			$(".pCount").text(data.criteria.totalcount);
			for(var i=0; i<data.recommend.length; i++){
				recommend+= '<div class="smart-post">' + 
								'<div class="post-thumb">' + 
								'<img src="'+ip+'/resources/uploadFile/images/'+data.recommend[i].file_name+'" alt="">' +
            					'</div>' + 
            					'<div class="post-explain">' + 
            						'<div class="post-title">'+data.recommend[i].product_name+'</div>' + 
              					'<div class="post-content">'+"판매수:"+data.recommend[i].sellnum+", 만족도 평균:"+data.recommend[i].staravg+'</div>' + 
              					'<div class="post-price">'+data.recommend[i].product_price+"원"+'</div>' + 
            					'</div>' + 
          					'</div>';
			}
			$(".smart-posts").append(recommend);
			for(var i=0; i<data.pList.length; i++){
				content+= '<div class="connect-post">' + 
							'<div class="post-thumb">' + 
								'<img src="'+ip+'/resources/uploadFile/images/'+data.pList[i].file_name+'" alt="">' + 
            				'</div>' + 
            				'<div class="post-explain">' + 
            					'<div class="post-title">'+data.pList[i].product_name+'</div>' + 
              				'<div class="post-content">'+"판매수:"+data.pList[i].sellnum+", 만족도 평균:"+data.pList[i].staravg+'</div>' + 
              				'<div class="post-price">'+data.pList[i].product_price+"원"+'</div>' + 
            				'</div>' + 
          				'</div>';
			}
			$("#comparePosts").append(content);
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
		},
		error: function(xhr, stat, err) {}
	});
});
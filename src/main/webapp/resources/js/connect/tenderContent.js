(function(){
	$.ajax({
		async:true,
		type:"post",
		url:"/member_devision",
		success:function(data){
			if(data == 'no'){ //사용자
				var html='<span>|</span>'
						+'<a id="tenderDeleteA" href="#">삭제</a>'
						+'<span>|</span>'
						+'<a id="tenderModifyA" href="#">수정</a>';
				$("#tenderADiv").append(html);
				
				var html2='<button id="tenderApplicationBtn">입찰신청</button>';
				$("#bidBtnBiv").append(html2);
			}else if(data == 'se'){ //사업자
				var html='<button id="bidWrite">투찰하기</button>'
				+'<button id="bidComplete">작성완료</button>'
				+'<button id="bidDelete">삭제하기</button>'
				+'<button id="bidModify" onclick="return confirm(&#39수정하시겠습니까?&#39);">수정하기</button>';
				
				$("#bidBtnBiv").append(html);
				$("#bidComplete").css("display","none");
				
				$('input[id="bid_ppt_score"]').attr("disabled", true);
				$(".bid_ppt_score_btn").attr("disabled", true);
			}else{ //관리자
				
			}
		}
	});
}());

(function(){
	var tender_code=$("#tcode").val();
	$.ajax({
		type:"POST",
		async:false,
		dataType:"json",
		url:"/tenderContent/"+tender_code,
		success:function(data){
			var bidArr=data.bidArr;
			var tenderVo=data.tenderVo;
			bidArr.sort(function(a,b){
				return a.totalScore > b.totalScore ? -1 : a.totalScore < b.totalScore ? 1 : 0;
			});
			
			var tenderHtml='<h2 id="tenderTitle">'+tenderVo.tender_title+'</h2>'
				+'<span id="tenderWriter">'+tenderVo.member_id+'</span>'
				+' | <span id="tenderDate">'+tenderVo.tcreationdate+'</span>'
				+' <span id="tenderDeadline">입찰 마감 일자 : '+tenderVo.tender_deadline+'</span>';
			$("#tenderContentDiv").append(tenderHtml);
			
			var tenderHtml2='<tr><td>입찰자 명</td><td>'+tenderVo.tender_name+'</td></tr>'
			+'<tr><td>주소</td><td>'+tenderVo.t_addr_do+tenderVo.t_addr_si+tenderVo.t_addr_dong+tenderVo.t_addr_detail+'</td></tr>'
			+'<tr><td>평수</td><td>'+tenderVo.t_space+'</td></tr>'
			+'<tr><td>층수</td><td>'+tenderVo.floor_number+'</td></tr>'
			+'<tr><td>서비스 일자</td><td>'+tenderVo.service_date+'</td></tr>'
			+'<tr><td>요구사항</td><td>'+tenderVo.requirement+'</td></tr>';
			$("#tenderTbl").append(tenderHtml2);
			
			for(var i=0; i<bidArr.length; i++){
				var bidHtml='<tr>'
					+'<td scope="row"><input type="radio" value='+bidArr[i].tender_code+' name="bidContent" ></td>'
					+'<td class="listC" data-label="순위">'+(i+1)+'</td>'
					+'<td id="company_name" name="company_name" class="listC" data-label="업체명">'+bidArr[i].company_name+'</td>'
					+'<td id="member_id" name="member_id" class="listC" data-label="대표자">'+bidArr[i].member_id+'</td>'
					+'<td id="bid_price" name="bid_price" data-label="금액">'+bidArr[i].bid_price+'</td>'
					+'<td data-label="건수">'+bidArr[i].bidNum+'</td>'
					+'<td data-label="별점">'+bidArr[i].star_score_avg+'</td>'
					+'<td data-label="첨부파일">'+bidArr[i].bid_ppt_name+'</td>'
					+'<td data-label="첨부파일 점수"><input type="text" id="bid_ppt_score" name="bid_ppt_score" value="'+bidArr[i].bid_ppt_score+'"><button class="bid_ppt_score_btn">입력</button></td>'
					+'<td data-label="비고">'+bidArr[i].note+'</td>'
					+'<td data-label="TOTAL 점수">'+bidArr[i].totalScore+'</td>'
				+'</tr>';
				 $("#tenderParticipationTbl tbody").append(bidHtml);
			}
		}
	});
}());
$(document).ready(function(){
	/*투찰 작성*/
	$(document).on('click','#bidWrite',function(){
		var tender_code=$("#tcode").val();
		$.ajax({
			type:"POST",
			url:"/BidPCheck/"+tender_code,
			success:function(data){
				if(data == "s"){
					alert("이미 참여한 입찰입니다.");
					return false;
				}else{
					bidWrite();
				}
			}
		});
	});
	function bidWrite(){
		$("#bidWrite").css("display","none");
		$("#bidComplete").css("display","inherit");
		
		var tbody='<tr> <td scope="row"><input type="radio">'
			+'</td> <td class="listC" data-label="순위">0</td>'
			+'<td id="aCompany_name" name="aCompany_name" class="listC" data-label="업체명"></td>'
			+'<td id="aMember_name" name="aMember_name" class="listC" data-label="대표자"></td>'
			+'<td data-label="금액"><input type="text" id="aBid_price" name="aBid_price" required autocomplete="off"></td>'
			+'<td id="bidNum" data-label="건수"></td>'
			+'<td id="star_score" data-label="별점"></td>'
			+'<td data-label="첨부파일"><input type="file" id="aBid_ppt_name" name="aBid_ppt_name"></td>'
			+'<td data-label="첨부파일 점수"><input type="text" id="bid_ppt_score" name="bid_ppt_score" disabled></td>'
			+'<td id="note" data-label="비고"></td>'
			+'<td data-label="TOTAL 점수">0</td></tr>';
		
		$("#tenderParticipationTbl tbody").append(tbody);
		
		$.ajax({
			type:"GET",
			url:"/addBid",
			dataType:"json",
			success:function(data){
				$("#aCompany_name").text(data.company_name);
				$("#aMember_name").text(data.member_name);
				$("#bidNum").text(data.bidNum);
				$("#star_score").text(data.star_score_avg);
				$("#note").text(data.note);
			}
		});
	};
	
	/*파일 업로드 확장자 체크*/
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz|jpg|png)$");
	var maxSize=10485760; //10MB
	
	function checkExtension(fileName, fileSize) {
		if(fileSize >= maxSize){
			alert("파일 사이즈 초과");
			return false;
		}
		if(regex.test(fileName)){
			alert("해당 종류의 파일은 업로드할 수 없습니다.");
			return false;
		}
		
		return true;
	}
	
	/*투찰 작성 완료 시*/
	$(document).on('click','#bidComplete',function(){
		//공백 체크
		var aBid_price=$("#aBid_price").val();
		var aBid_ppt_name=$("#aBid_ppt_name").val();
		if(aBid_price == "" || aBid_ppt_name == ""){
			alert("입력 양식을 다 채워주세요");
			return false;
		}
		
		var formData = new FormData();
		var inputFile=$("input[name='aBid_ppt_name']");
		var files=inputFile[0].files;
		
		
		for(var i = 0; i < files.length; i++){
			if(!checkExtension(files[i].name, files[i].size) ){
				return false;
			}
			
			formData.append("uploadFile",files[i]);
		}
		
		formData.append("sBid_price",$("#aBid_price").val());
		formData.append("tender_code",$("#tcode").val());
		
		$.ajax({
			type:"post",
			url:"/addBidComplete",
			data:formData,
			processData:false,
			contentType:false,
			success:function(data){
				alert("등록 완료");
				location.href="/tenderContent/"+$("#tcode").val();
			}
		});
		
	});
	
	/*투찰 삭제*/
	$(document).on('click','#bidDelete',function(){
		var c=confirm('삭제하시겠습니까?');
		if(c){
			var tender_code=$("#tcode").val();
			// 투찰에 대한 사업자번호
			var company_code=$('input:radio[name="bidContent"]:checked').val();
			var query={
					company_code:company_code,
					tender_code:tender_code
			};
		
			$.ajax({
				type:"POST",
				url:"/bidDelete/",
				data:query,
				success:function(data){
					if(data == "s"){
						location.href="/tenderContent/"+tender_code;
					}else{
						alert("삭제할 권한이 없습니다.");
						$('input:radio[name="bidContent"]:checked').prop('checked',false);
					return false;
				}
				}
			});
		}
	});
	
	/*투찰 수정*/
	$(document).on('click','#bidModify',function(){
		var tender_code=$("#tcode").val();
		// 투찰에 대한 사업자번호
		var company_code=$('input:radio[name="bidContent"]:checked').val();
		var query={
				company_code:company_code,
				tender_code:tender_code
		};
		
		$.ajax({
			type:"POST",
			url:"/bidModify",
			data:query,
			success:function(data){
				if(data == "s"){
					bidModify();
				}else{
					alert("수정할 권한이 없습니다.");
					$('input:radio[name="bidContent"]:checked').prop('checked',false);
					return false;
				}
			}
		});
	});
	
	$(document).on('click','#tenderModifyA',function(){
		var c=confirm('수정하시겠습니까?');
		var tender_code=$("#tcode").val();
		if(c){
			window.location.href="/tenderModify/"+tender_code;
		}
	});
	
	$(document).on('click','#tenderDeleteA',function(){
		var c=confirm('삭제하시겠습니까?');
		var tender_code=$("#tcode").val();
		if(c){
			window.location.href="/tenderDelete/"+tender_code;
		}
	});
	
	function bidModify(){
		
	}
	
});
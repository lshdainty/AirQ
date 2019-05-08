(function(){
	$.ajax({
		async:true,
		type:"POST",
		url:"/member_devision",
		success:function(data){
			if(data == 'no'){ //사용자
				var html='<span>|</span>'
						+'<a href="/tenderDelete/${tenderContent.tender_code }" onclick="return confirm(&#39삭제하시겠습니까?&#39);">삭제</a>'
						+'<span>|</span>'
						+'<a href="/tenderModify/${tenderContent.tender_code }" onclick="return confirm(&#39수정하시겠습니까?&#39);">수정</a>';
				$("#tenderADiv").append(html);
				
				var html2='<button id="tenderApplicationBtn">입찰신청</button>';
				$("#bidBtnBiv").append(html2);
			}else if(data == 'se'){ //사업자
				var html='<button id="bidWrite">투찰하기</button>'
				+'<button id="bidComplete">작성완료</button>'
				+'<button id="bidDelete" onclick="return confirm(&#39삭제하시겠습니까?&#39);">삭제하기</button>'
				+'<button id="bidModify" onclick="return confirm(&#39수정하시겠습니까?&#39);">수정하기</button>';
				
				$("#bidBtnBiv").append(html);
				$("#bidComplete").css("display","none");
				
				$('input[id="bid_ppt_score"]').attr("disabled", false);
			}else{ //관리자
				
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
	
	function bidModify(){
		
	}
	
});
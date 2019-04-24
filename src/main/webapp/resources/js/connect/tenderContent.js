$(document).ready(function(){
	
	/*투찰 작성*/
	$("#bidComplete").css("display","none");
	$(document).on('click','#bidWrite',function(){
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
	});
	
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
				/*location.href="/tenderContent/"+$("#tcode").val();*/
				alert("success");
			}
		});
	});
});
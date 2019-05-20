(function(){
	var tender_code=$("#tcode").val();
	$.ajax({
		async:true,
		type:"post",
		dataType:"json",
		url:"/member_devision/"+tender_code,
		success:function(data){
			if(data.tenderCheck == '0'){
				if(data.member_devision == 'no'){ //사용자
					var html='<span>|</span>'
							+'<a id="tenderDeleteA" href="#">삭제</a>'
							+'<span>|</span>'
							+'<a id="tenderModifyA" href="#">수정</a>';
					$("#tenderADiv").append(html);
				
					var html2='<button id="tendering">입찰신청</button>';
					$("#bidBtnBiv").append(html2);
				}else if(data.member_devision == 'se'){ //사업자
					var html='<button id="bidWrite">투찰하기</button>'
					+'<button id="bidComplete">작성완료</button>'
					+'<button id="bidDelete">삭제하기</button>'
					+'<button id="bidModify" onclick="return confirm(&#39수정하시겠습니까?&#39);">수정하기</button>';
					
					var html2='<span>|</span>'
						+'<a id="reportButton" href="#">신고</a>';
					
					$("#bidBtnBiv").append(html);
					$("#tenderADiv").append(html2);
					$("#bidComplete").css("display","none");
				
					$('input[id="bid_ppt_score"]').attr("disabled", true);
					$(".bid_ppt_score_btn").attr("disabled", true);
				}else{ //관리자
					var html='<span>|</span>'
						+'<a id="tenderDeleteA" href="#">삭제</a>';
					$("#tenderADiv").append(html);
				}
			} else {
				$('input[id="bid_ppt_score"]').attr("disabled", true);
				$(".bid_ppt_score_btn").attr("disabled", true);
				alert("종료된 입찰입니다.");
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
			
			if(tenderVo.calculate_period != 0){
				var period=tenderVo.calculate_period;
				period=Math.abs(period);
				var periodHtml = '<span id="periodSpan"> (최근 '+period+'개월의 기록만 보여줍니다.)</span>';
				$("#tenderParticipationList").append(periodHtml);
			}else {
				var periodHtml = '<span id="periodSpan"> (사업자의 전체 기록을 보여줍니다.)</span>';
				$("#tenderParticipationList").append(periodHtml);
			}
			
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
				var bidHtml='<tr class="bidTr">'
					+'<td scope="row"><input type="radio" value='+bidArr[i].company_code+' name="bidContent" ></td>'
					+'<td class="listC" data-label="순위">'+(i+1)+'</td>'
					+'<td id="company_name" name="company_name" class="listC" data-label="업체명">'+bidArr[i].company_name+'</td>'
					+'<td id="member_id" name="member_id" class="listC" data-label="대표자">'+bidArr[i].member_id+'</td>'
					+'<td id="bid_price" name="bid_price" data-label="금액">'+bidArr[i].bid_price+'</td>'
					+'<td data-label="건수">'+bidArr[i].bidNum+'</td>'
					+'<td data-label="별점">'+bidArr[i].star_score_avg+'</td>'
					+'<td data-label="첨부파일">'+bidArr[i].bid_ppt_name+'</td>'
					+'<td data-label="첨부파일 점수"><input type="number" id="bid_ppt_score" name="bid_ppt_score" min="0" max="50" value="'+bidArr[i].bid_ppt_score+'"><button class="bid_ppt_score_btn">입력</button></td>'
					+'<td data-label="비고">'+bidArr[i].note+'</td>'
					+'<td data-label="TOTAL 점수">'+bidArr[i].totalScore+'</td>'
				+'</tr>';
				 $("#tenderParticipationTbl tbody").append(bidHtml);
				 console.log(bidArr[i]);
			}
		}
	});
}());
$(document).ready(function(){
	/*입찰 신청*/
	$(document).on('click','#tendering',function(){
		var c=confirm('결제하시겠습니까?');
		if(c){
			var tender_code=$("#tcode").val();
			// 투찰에 대한 사업자번호
			var company_code=$('input:radio[name="bidContent"]:checked').val();
			var query={
				tender_code:tender_code,
				company_code:company_code
			};
			
			$.ajax({
				type:"POST",
				data:query,
				url:"/tendering",
				success:function(){
					window.location.reload();
				}
			});
		}else{
			return false;
		}
		
	});
	
	/*ppt점수 부여*/
	$(document).on('click','.bid_ppt_score_btn',function(){
		
		var tender_code=$("#tcode").val();
		var index=$(".bid_ppt_score_btn").index(this);
		var company_code=$(".bidTr:eq("+index+") > td:first-child > input").val();
		var bid_ppt_score=$(".bidTr:eq("+index+") #bid_ppt_score").val();
		
		var query={
				tender_code:tender_code,
				company_code:company_code,
				bid_ppt_score:bid_ppt_score
		};
		
		if(bid_ppt_score>50){
			alert("ppt점수는 0~50점까지 입력가능합니다.");
			$(".bidTr:eq("+index+") #bid_ppt_score").val(0);
			return false;
		}
		
		$.ajax({
			type:"post",
			data:query,
			url:"/bid_ppt_score",
			success:function(data){
				window.location.reload();
			}
		});
	});
	
	
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
		
		var tender_code=$("#tcode").val();
		
		$.ajax({
			type:"GET",
			url:"/addBid/"+tender_code,
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
		var tender_code=$("#tcode").val();
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
			url:"/addBidComplete/"+tender_code,
			data:formData,
			processData:false,
			contentType:false,
			success:function(data){
				alert("등록 완료");
				window.location.reload();
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
			alert(company_code);
			$.ajax({
				type:"POST",
				url:"/bidDelete",
				data:query,
				dataType:"text",
				success:function(data){
					if(data == "s"){
						window.location.reload();
					}else{
						alert("삭제할 권한이 없습니다.");
						$('input:radio[name="bidContent"]:checked').prop('checked',false);
					return false;
					}
				}
			});
		}else{
			return false;
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
		}else{
			return false;
		}
	});
	
	$(document).on('click','#tenderDeleteA',function(){
		var c=confirm('삭제하시겠습니까?');
		var tender_code=$("#tcode").val();
		if(c){
			window.location.href="/tenderDelete/"+tender_code;
		}else{
			return false;
		}
	});
	
	function bidModify(){
		
	}
	
	/*신고하기*/
	$(document).on('click','#reportButton',function(){
		var tender_code=$("#tcode").val();
    	//기존에 신고한 내용이 있는지 확인
    	$.ajax({
    		type: "get",
    		url: "/checkReport",
    		data : {original_code : tender_code},
    		async: false,
    		success: function(data) {
    			if(data=="success"){
    				windowObj = window.open("/report?original_code="+tender_code,"report","width=570px, height=600px");
    			}else{
    				alert("신고는 한번만 가능합니다.");
    			}
    		},
    		error: function(xhr, stat, err) {}
    	});
	});
	
});
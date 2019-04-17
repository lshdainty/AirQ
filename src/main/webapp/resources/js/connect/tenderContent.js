$(document).ready(function(){
	
	/*투찰 작성*/
	$("#bidComplete").css("display","none");
	$(document).on('click','#bidWrite',function(){
		$("#bidWrite").css("display","none");
		$("#bidComplete").css("display","inherit");
		
		var tbody='<tr> <td scope="row"><input type="radio">'
			+'</td> <td class="listC" data-label="순위">0</td>'
			+'<td id="company_name" class="listC" data-label="업체명"></td>'
			+'<td id="member_id" class="listC" data-label="대표자"></td>'
			+'<td data-label="금액"><input type="text" id="bid_price" name="bid_price"></td>'
			+'<td id="bidNum" data-label="건수"></td>'
			+'<td id="star_score" data-label="별점"></td>'
			+'<td data-label="첨부파일"><input type="file" id="bid_ppt_name"></td>'
			+'<td id="note" data-label="비고"></td>'
			+'<td data-label="TOTAL 점수">0</td></tr>';
		
		$("#tenderParticipationTbl tbody").append(tbody);
		
		$.ajax({
			type:"GET",
			url:"/addBid",
			success:function(data){
				$("#company_name").text(data.company_name);
				$("#member_id").text(data.member_id);
				$("#bidNum").text(data.bidNum);
				$("#star_score").text(data.star_score_avg);
				$("#note").text(data.note);
			}
		});
	});
	
	/*투찰 작성 완료 시*/
	$(document).on("click","#bidComplete",function(){
		
	});
});
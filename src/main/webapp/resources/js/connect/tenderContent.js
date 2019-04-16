$(document).ready(function(){
	$(document).on('click','#bid',function(){
		
		
		var tbody='<tr> <td scope="row"><input type="radio">'
			+'</td> <td class="listC" data-label="순위"></td>'
			+'<td id="company_name" class="listC" data-label="업체명"></td>'
			+'<td id="member_id" class="listC" data-label="대표자"></td>'
			+'<td data-label="금액"><input type="text" id="bid_price" name="bid_price"></td>'
			+'<td id="bidNum" data-label="건수"></td>'
			+'<td data-label="별점"></td>'
			+'<td data-label="첨부파일"><input type="file" id="bid_ppt_name"></td>'
			+'<td data-label="비고"></td>'
			+'<td data-label="TOTAL 점수"></td> </tr>';
		
		$("#tenderParticipationTbl tbody").append(tbody);
		
		$.ajax({
			type:"GET",
			url:"/addBid",
			success:function(data){
				$("#company_name").text(data.company_name);
				$("#member_id").text(data.member_id);
				$("#bidNum").text(data.bidNum);
			}
		});
	});
});
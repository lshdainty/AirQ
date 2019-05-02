package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yjc.airq.domain.PaymentVO;

public interface PaymentMapper {
	// 서비스 제품 주문정보 insert
	public void pInsertPayment(PaymentVO paymentVO);
	
	//마이페이지 일반사용자 결제내역
	@Select("select d.member_id, d.demand_code, p.star_score , p.payment_code, to_char(d.demand_date,'yyyy-mm-dd') as day" + 
			" from payment p, demand d, member m" + 
			" where m.member_id = d.member_id" + 
			" and d.demand_code = p.demand_code" + 
			" and m.member_id = #{member_id}" + 
			" GROUP by d.MEMBER_ID,p.STAR_SCORE,d.DEMAND_CODE, p.payment_code, to_char(d.demand_date,'yyyy-mm-dd')")
	public ArrayList<PaymentVO> mypay(@Param("member_id")String member_id);
}

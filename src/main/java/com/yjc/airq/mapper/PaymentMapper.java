package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yjc.airq.domain.PaymentVO;

public interface PaymentMapper {
	// 서비스 제품 주문정보 insert
	public void pInsertPayment(PaymentVO paymentVO);
	
	// 서비스 제품 결제 삭제
	public void productPaymentDelete(@Param("product_code") String product_code);
	
	//마이페이지 일반사용자 결제내역
	@Select("select d.member_id, d.demand_code, p.star_score , p.payment_code, to_char(d.demand_date,'yyyy-mm-dd') as day, c.company_name, c.MEMBER_ID as company_id,pr.PRODUCT_NAME, DBMS_LOB.SUBSTR(pr.product_detail,4000,1) as product_detail" + 
			" from payment p, demand d, member m, product pr, company_info c" + 
			" where m.member_id = d.member_id" + 
			" and d.demand_code = p.demand_code" +
			" and d.product_code = pr.product_code" +
			" and pr.company_code = c.company_code" +
			" and m.member_id = #{member_id}" +
			" and p.REFUND_WHETHER ='n'" +
			" GROUP by d.MEMBER_ID,p.STAR_SCORE,d.DEMAND_CODE, p.payment_code, to_char(d.demand_date,'yyyy-mm-dd'), c.company_name, c.MEMBER_ID,pr.PRODUCT_NAME, DBMS_LOB.SUBSTR(pr.product_detail,4000,1)"+
			" order by to_char(d.demand_date,'yyyy-mm-dd') desc")
	public ArrayList<PaymentVO> mypay(@Param("member_id")String member_id);
	
	@Select("select d.member_id, d.demand_code, p.star_score , p.payment_code, to_char(d.demand_date,'yyyy-mm-dd') as day, c.company_name, c.MEMBER_ID as company_id,pr.PRODUCT_NAME, DBMS_LOB.SUBSTR(pr.product_detail,4000,1) as product_detail" + 
			" from payment p, demand d, member m, product pr, company_info c" + 
			" where m.member_id = d.member_id" + 
			" and d.demand_code = p.demand_code" + 
			" and d.product_code = pr.product_code" +
			" and pr.company_code = c.company_code" +
			" and m.member_id = #{member_id}" +
			" and not p.star_score is null" +
			" and p.REFUND_WHETHER ='n'" +
			" GROUP by d.MEMBER_ID,p.STAR_SCORE,d.DEMAND_CODE, p.payment_code, to_char(d.demand_date,'yyyy-mm-dd'), c.company_name, c.MEMBER_ID,pr.PRODUCT_NAME, DBMS_LOB.SUBSTR(pr.product_detail,4000,1)"+
			" order by to_char(d.demand_date,'yyyy-mm-dd') desc")
	public ArrayList<PaymentVO> mypayNotNull(@Param("member_id")String member_id);
	
	@Select("select d.member_id, d.demand_code, p.star_score , p.payment_code, to_char(d.demand_date,'yyyy-mm-dd') as day, c.company_name, c.MEMBER_ID as company_id,pr.PRODUCT_NAME, DBMS_LOB.SUBSTR(pr.product_detail,4000,1) as product_detail" + 
			" from payment p, demand d, member m, product pr, company_info c" + 
			" where m.member_id = d.member_id" + 
			" and d.demand_code = p.demand_code" + 
			" and d.product_code = pr.product_code" +
			" and pr.company_code = c.company_code" +
			" and m.member_id = #{member_id}" +
			" and p.star_score is null" +
			" and p.REFUND_WHETHER ='n'" +
			" GROUP by d.MEMBER_ID,p.STAR_SCORE,d.DEMAND_CODE, p.payment_code, to_char(d.demand_date,'yyyy-mm-dd'), c.company_name, c.MEMBER_ID,pr.PRODUCT_NAME, DBMS_LOB.SUBSTR(pr.product_detail,4000,1)"+
			" order by to_char(d.demand_date,'yyyy-mm-dd') desc")
	public ArrayList<PaymentVO> mypayNull(@Param("member_id")String member_id);
	
//	@Update("")
//	public 
}
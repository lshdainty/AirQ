package com.yjc.airq.domain;

import lombok.Data;

@Data
public class PaymentVO {
	private String payment_code;
	private int payment_price;
	private String refund_whether;
	private int star_score;
	private String demand_code;
	private String tender_code;
	private DemandVO demandVO;
	
	private String day;
	private String company_name;
	private String company_id;
	private String product_detail;
}
package com.yjc.airq.domain;

import lombok.Data;

@Data
public class MemberVO {
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_tel;
	private String member_email;
	private String m_addr_do;
	private String m_addr_si;
	private String m_addr_dong;
	private String m_addr_detail;
	private String member_devision;
}
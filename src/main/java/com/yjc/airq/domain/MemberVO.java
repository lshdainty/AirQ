package com.yjc.airq.domain;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String email;
	private int tel;
	private String address;
}

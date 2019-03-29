package com.yjc.airq.domain;

import java.sql.Timestamp;
import java.sql.Date;

import lombok.Data;

@Data
public class TenderboardVO {
	private int rownum;
	private String tcode;
	private String ttitle;
	private String tname;
	private Timestamp tcreated;
	private Date tdeadline;
	private String taddress;
	private int tfloorspace;
	private int tlayers;
	private String trequirement;
	private Date tmeasurementdate;
}

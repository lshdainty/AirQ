package com.yjc.airq.domain;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class TenderboardVO {
	private String tCode;
	private String tTitle;
	private String tName;
	private Timestamp tCreate;
	private Date tDeadline;
	private String tAddress;
	private int tFloorspace;
	private int tLayers;
	private String tRequirement;
	private Date tMeasurementdate;
}

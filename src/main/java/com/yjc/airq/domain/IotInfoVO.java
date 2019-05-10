package com.yjc.airq.domain;

import lombok.Data;

@Data
public class IotInfoVO {
	private String iot_id;
	private String out_whether;
	private String place_name;
	private int measure_cycle;
	private String location_x;
	private String location_y;
	private int port;
	private String member_id;
	private String model_id;
	
	private String model_name;
}

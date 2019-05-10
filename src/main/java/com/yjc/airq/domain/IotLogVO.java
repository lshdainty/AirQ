package com.yjc.airq.domain;

import java.security.Timestamp;

import lombok.Data;

@Data
public class IotLogVO {
	private String iot_id;
	private Timestamp action_time;
	private String action_whether;
}

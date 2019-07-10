package com.yjc.airq.domain;

public class Recommend {
	private String recommend;	//선택된 추천문구
	private String matter;	//물질
	private int grade;	//물질에 대한 등급
	private String[] PM = {"최적의 공기 상태에요. 이 상태를 유지해주세요.",
							"최적의 공기 상태에요. 이 상태를 유지해주세요.",
							"좋은 공기 상태에요. 30분간 환기를 시켜주면 더 좋아요.",
							"좋은 공기 상태에요. 30분간 환기를 시켜주면 더 좋아요.",
							"공기 상태가 좋지 않아요. 공기청정기를 가동하거나 환기를 시켜주세요.",
							"공기 상태가 좋지 않아요. 공기청정기를 가동하거나 환기를 시켜주세요.",
							"공기 상태가 최악이에요. 이 상태가 지속될 시 공기 질 개선 서비스를 받으세요.",
							"공기 상태가 최악이에요. 이 상태가 지속될 시 공기 질 개선 서비스를 받으세요."};
	private String[] CO2 = {"최적의 공기 상태에요. 이 상태를 유지해주세요.",
							"최적의 공기 상태에요. 이 상태를 유지해주세요.",
							"좋은 공기 상태에요. 30분간 환기를 시켜주면 더 좋아요.",
							"예민한 사람은 불쾌감을 느낄 수 있어요. 환기를 해주세요.",
							"졸음이 느껴지지 않나요? 이산화탄소 농도가 높아요. 환기를 해주세요.",
							"어깨 결림이나 두통을 느끼진 않나요? 이산화탄소 농도가 높아요. 환기를 시키고 다른 곳으로 대피하세요.",
							"두통, 현기증을 느끼진 않나요? 이산화탄소 농도가 너무 높아요. 환기를 시키고 다른 곳으로 대피하세요.",
							"영구적인 뇌 손상을 일으킬 만큼 심각합니다. 다른 곳으로 대피하세요."};
	
	public void setRecommend() {
		if(matter.equals("PM10")) {
			for(int i=0; i<PM.length; i++) {
				if(grade == i+1) {
					recommend = PM[i];
				}
			}
		}else if(matter.equals("CO2")) {
			for(int i=0; i<PM.length; i++) {
				if(grade == i+1) {
					recommend = CO2[i];
				}
			}
		}
	}
	
	public String getRecommend() {
		return recommend;
	}
	
	public void setMatter(String matter) {
		this.matter = matter;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
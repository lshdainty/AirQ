package com.yjc.airq.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.yjc.airq.domain.AreaVO;
import com.yjc.airq.domain.ProductVO;
import com.yjc.airq.domain.TenderboardVO;
import com.yjc.airq.mapper.AreaMapper;
import com.yjc.airq.mapper.ProductMapper;
import com.yjc.airq.mapper.TenderboardMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConnectServiceImplement implements ConnectService {
	private TenderboardMapper tenderMapper;
	private ProductMapper productMapper;
	private AreaMapper areaMapper;
	
	// 입찰 리스트 출력
	@Override
	public ArrayList<TenderboardVO> tenderList() {
		return tenderMapper.tenderList();
	}
	
	// 입찰 공고 작성
	@Override
	public int addTenderboard(TenderboardVO tenderboardVo) {
		return tenderMapper.addTenderboard(tenderboardVo);
	}
	
	//입찰 세부 내용 보기
	@Override
	public TenderboardVO tenderContent(String tcode) {
		return tenderMapper.tenderContent(tcode);
	}
	
	//입찰 공고 삭제
	@Override
	public int tenderDelete(String tcode) {
		return tenderMapper.tenderDelete(tcode);
	}
	
	//입찰 공고 수정
	@Override
	public int tenderModify(TenderboardVO tenderboardVo) {
		return tenderMapper.tenderModify(tenderboardVo);
	}
	
	// 상품 리스트 출력
	@Override
	public ArrayList<ProductVO> productList(@Param("startnum") int startnum,  @Param("endnum") int endnum){
		return productMapper.productList(startnum,endnum);
	};
	
	// 상품중 서비스 가능한 지역 리스트 출력
	@Override
	public ArrayList<AreaVO> productAreaList(){
		return areaMapper.productAreaList();
	};
	
	// 사용자가 선택한 도,시,평수에 해당하는 제품목록
	@Override
	public ArrayList<ProductVO> selectList(@Param("sido") String sido,@Param("sigoon") String sigoon,@Param("space") int space){
		return productMapper.selectList(sido,sigoon,space);
	};
}

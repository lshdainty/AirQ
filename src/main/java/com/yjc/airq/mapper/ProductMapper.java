package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.ProductVO;

public interface ProductMapper {
	// 상품리스트 조회
	public ArrayList<ProductVO> productList(@Param("startnum") int startnum,  @Param("endnum") int endnum);
	// 상품 전체 개수 조회
	public int productCount();
	// 사용자가 선택한 옵션에 해당하는 리스트 조회
	public ArrayList<ProductVO> selectList(@Param("sido") String sido,@Param("sigoon") String sigoon,@Param("space") int space, @Param("startnum") int startnum,  @Param("endnum") int endnum);
	// 항목 선택후 항목에 맞는 상품 개수 조회
	public int selectCount(@Param("sido") String sido,@Param("sigoon") String sigoon,@Param("space") int space);
	// 상품 상세 페이지
	public ProductVO productContent(String product_code);
	// 마이페이지- 관리자 프로덕트 리스트 조회
	public ArrayList<ProductVO> productMP();
	//마이페이지 관리자 글관리 - 글삭제
	@Delete("delete from product where product_code=#{product_code}")
	public boolean deletePostsProduct(String product_code);
}

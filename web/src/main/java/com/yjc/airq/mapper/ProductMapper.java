package com.yjc.airq.mapper;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.ProductVO;

public interface ProductMapper {
	// 사용자가 사는곳에서 많이 팔린 제품 리스트
	public ArrayList<ProductVO> recommendList(@Param("zipcode") String zipcode);
	// 상품리스트 조회
	public ArrayList<ProductVO> productList(@Param("sort") String sort, @Param("startnum") int startnum, @Param("endnum") int endnum);
	// 상품 전체 개수 조회
	public int productCount();
	// 사용자가 선택한 옵션에 해당하는 리스트 조회
	public ArrayList<ProductVO> selectList(@Param("sido") String sido, @Param("sigoon") String sigoon, @Param("space") int space, @Param("matter") String matter, @Param("sort") String sort, @Param("startnum") int startnum,  @Param("endnum") int endnum);
	// 항목 선택후 항목에 맞는 상품 개수 조회
	public int selectCount(@Param("sido") String sido,@Param("sigoon") String sigoon,@Param("space") int space,@Param("matter") String matter);
	// 상품 상세 페이지
	public ProductVO productContent(String product_code);
	// 작성글 수정,삭제 권한 체크
	public String writePersonCheck(@Param("product_code") String product_code);
	// 서비스 제품 등록
	public void productInsert(ProductVO productVO);
	// 서비스 제품 수정
	public void productUpdate(ProductVO productVO);
	// 서비스 제품 삭제
	public void productDelete(@Param("product_code") String product_code);
	// 마이페이지 메인 - 관리자 프로덕트 리스트 조회
	public ArrayList<ProductVO> productMP();
	//마이페이지 관리자 글관리 - 글수정
	public void deletePostsProduct(@Param("product_code") String product_code);
	//마이페이지 관리자 글관리 - 글삭제
//	public void deletePostsProduct1(@Param("product_code") String product_code);
	//마이페이지 판매자 글관리 -글삭제
	public ArrayList<ProductVO> productSMP(@Param("member_id")String member_id);
	//마이페이지 예약정보
	public ArrayList<Map<String, Object>> reservationInfo(String company_code);
	//마이페이지 인기상품
	public ArrayList<Map<String,Object>> hotItemInfo(String company_code);
	// 리뷰 안 한 목록 리스트
	public ArrayList<ProductVO> reviewCompareList(String member_id);
}

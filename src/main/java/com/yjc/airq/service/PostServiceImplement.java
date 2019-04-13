package com.yjc.airq.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.yjc.airq.domain.Criteria;
import com.yjc.airq.domain.PostVO;
import com.yjc.airq.mapper.PostMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostServiceImplement implements PostService {
	private PostMapper mapper;
	@Override
	public ArrayList<PostVO> getPosts(@Param("startnum") int startnum, @Param("endnum") int endnum,@Param("board_code")String board_code) {
		// TODO Auto-generated method stub
		
		return mapper.getPosts(startnum,endnum,board_code);
	}
	
	@Override
	public PostVO detailPost(String post_code) {
		// TODO Auto-generated method stub
		mapper.viewCount(post_code);
		return mapper.detailPost(post_code);
	}
	
	@Override
	public String fileInfo(String post_code) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insertPost(PostVO post) {
		// TODO Auto-generated method stub
		mapper.insertPost(post);
	}


	@Override
	public void deletePost(String post_code) {
		// TODO Auto-generated method stub
		mapper.deletePost(post_code);
		
	}

	@Override
	public void modifyPost(PostVO post) {
		// TODO Auto-generated method stub
		
		mapper.modifyPost(post);
		
	}
	
	public void viewCount(String post_code) {
		mapper.viewCount(post_code);
	}
	
	public void postVote(String post_code) {
		mapper.postVote(post_code);
	}
	public int postCount(String board_code) {
		return mapper.postCount(board_code);
	}

}

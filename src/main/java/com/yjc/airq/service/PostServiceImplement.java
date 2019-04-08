package com.yjc.airq.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yjc.airq.domain.PostVO;
import com.yjc.airq.mapper.PostMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostServiceImplement implements PostService {
	private PostMapper mapper;
	@Override
	public ArrayList<PostVO> getPosts() {
		// TODO Auto-generated method stub
		
		return mapper.getPosts();
	}
	
	@Override
	public PostVO detailPost(String post_code) {
		// TODO Auto-generated method stub
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

}

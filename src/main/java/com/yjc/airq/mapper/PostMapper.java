package com.yjc.airq.mapper;

import java.util.ArrayList;

import com.yjc.airq.domain.PostVO;

public interface PostMapper {
	
	public ArrayList<PostVO> getPosts();
	public void insertPost(PostVO post);
	public PostVO detailPost(String post_code);
	public void deletePost(String post_code);
	public void modifyPost(PostVO post);
}

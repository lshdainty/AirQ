package com.yjc.airq.service;

import java.util.ArrayList;

import com.yjc.airq.domain.PostVO;

public interface PostService {
	ArrayList<PostVO> getPosts();
	void insertPost(PostVO postVO);
	void modifyPost(PostVO postVO);
	void deletePost(String post_code);
	PostVO detailPost(String post_code);
	String fileInfo(String post_code);
}

package com.yjc.airq.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.PostVO;

public interface PostService {
	ArrayList<PostVO> getPosts(@Param("startnum") int startnum, @Param("endnum") int endnum,@Param("board_code")String board_code);
	void insertPost(PostVO postVO);
	void modifyPost(PostVO postVO);
	void deletePost(String post_code);
	PostVO detailPost(String post_code);
	String fileInfo(String post_code);
	void viewCount(String post_code);
	void postVote(String post_code);
	int postCount(String board_code);
}

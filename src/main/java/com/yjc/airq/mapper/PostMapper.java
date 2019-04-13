package com.yjc.airq.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.yjc.airq.domain.PostVO;

public interface PostMapper {
	
	public ArrayList<PostVO> getPosts(@Param("startnum") int startnum, @Param("endnum") int endnum,@Param("board_code")String board_code);
	public void insertPost(PostVO post);
	public PostVO detailPost(String post_code);
	public void deletePost(String post_code);
	public void modifyPost(PostVO post);
	public void viewCount(String post_code);
	public void postVote(String post_code);
	public int postCount(String board_code);
}

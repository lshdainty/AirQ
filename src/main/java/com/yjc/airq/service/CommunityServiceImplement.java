package com.yjc.airq.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.yjc.airq.domain.PostVO;
import com.yjc.airq.domain.ReplyVO;
import com.yjc.airq.mapper.PostMapper;
import com.yjc.airq.mapper.ReplyMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommunityServiceImplement implements CommunityService {
	private PostMapper postMapper;
	private ReplyMapper replyMapper;
	@Override
	public ArrayList<PostVO> getPosts(@Param("startnum") int startnum, @Param("endnum") int endnum,@Param("board_code")String board_code) {
		// TODO Auto-generated method stub
		
		return postMapper.getPosts(startnum,endnum,board_code);
	}
	
	@Override
	public PostVO detailPost(String post_code) {
		// TODO Auto-generated method stub
		postMapper.viewCount(post_code);
		return postMapper.detailPost(post_code);
	}
	
	@Override
	public String fileInfo(String post_code) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insertPost(PostVO post) {
		// TODO Auto-generated method stub
		postMapper.insertPost(post);
	}


	@Override
	public void deletePost(String post_code) {
		// TODO Auto-generated method stub
		postMapper.deletePost(post_code);
		
	}

	@Override
	public void modifyPost(PostVO post) {
		// TODO Auto-generated method stub
		
		postMapper.modifyPost(post);
		
	}
	
	public void viewCount(String post_code) {
		postMapper.viewCount(post_code);
	}
	
	public void postVote(String post_code) {
		postMapper.postVote(post_code);
	}
	public int postCount(String board_code) {
		return postMapper.postCount(board_code);
	}
	@Override
	public ArrayList<ReplyVO> getReplys(String post_code) {
		
		return replyMapper.getReplys(post_code);
	}

	@Override
	public void insertReply(ReplyVO replyVO) {
		replyMapper.insertReply(replyVO);
	}
	public void deletePostReply(String post_code) {
		replyMapper.deletePostReply(post_code);
	}
	public void replyDelete(String reply_code) {
		replyMapper.replyDelete(reply_code);
	}

	@Override
	public ArrayList<ReplyVO> mypageReplys() {
		return replyMapper.mypageReplys();
	}
}

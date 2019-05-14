package com.yjc.airq.service;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
import com.yjc.airq.domain.PostVO;
import com.yjc.airq.domain.ReplyVO;

public interface CommunityService {
	ArrayList<PostVO> getPosts(@Param("startnum") int startnum, @Param("endnum") int endnum,@Param("board_code")String board_code);
	void insertPost(PostVO postVO);
	void modifyPost(PostVO postVO);
	void deletePost(String post_code);
	PostVO detailPost(String post_code);
	String fileInfo(String post_code);
	void viewCount(String post_code);
	void postVote(String post_code);
	int postCount(String board_code);
	ArrayList<ReplyVO> getReplys(String post_code);
	void insertReply(ReplyVO replyVO);
	void deletePostReply(String post_code);
	void replyDelete(String reply_code);
	ArrayList<ReplyVO> mypageReplys();
}

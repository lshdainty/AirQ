package com.yjc.airq;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PostVO;
import com.yjc.airq.domain.ReplyVO;
import com.yjc.airq.service.PostService;
import com.yjc.airq.service.ReplyService;
import com.yjc.airq.service.UploadService;

import lombok.AllArgsConstructor;

/**
 * 커뮤니티 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class CommunityController {
	
	private PostService postService;
	private UploadService uploadService;
	private ReplyService replyService;
	
	@RequestMapping(value = "addReply", method = RequestMethod.POST)
	@ResponseBody
	public String addReply(ReplyVO replyVO,Model model,HttpServletRequest request) {
		System.out.println(replyVO);
		// 댓글 코드 생성
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		int random=(int)(Math.random()*10000);
		String reply_code="rp"+day+random;
		// 댓글 코드 생성 완료
		String reply_content = request.getParameter("reply_content");
		Timestamp r_creation_date = new Timestamp(System.currentTimeMillis());
		String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
    	String product_code=request.getParameter("product_code");
    	String post_code=request.getParameter("post_code");
    	
	    	if(product_code==null)
	    		product_code="";
	    	if(post_code==null)
	    		post_code="";
	    	
		
		replyVO.setReply_code(reply_code);
		replyVO.setReply_content(reply_content);
		replyVO.setR_creation_date(r_creation_date);
		replyVO.setMember_id(member_id);
		replyVO.setPost_code(post_code);
		replyVO.setProduct_code(product_code);
		
		replyService.insertReply(replyVO);
		return "success";
	}
	@RequestMapping(value = "postVote", method = RequestMethod.POST)
	@ResponseBody
	public String postVote(Model model ,String post_code) {
		
		System.out.println(post_code);
		postService.postVote(post_code);
		
		return "success";
	}
	
	//상품추천 메인페이지로 가기
	@RequestMapping(value = "recommendMain", method = RequestMethod.GET)
	public String recommendMain(Model model) {
		
		// 데이터베이스에서 모든 포스트를 불러옴
		ArrayList<PostVO> posts=postService.getPosts("bd_rec");
		
		// 불러온 포스트 중의 컨텐츠에서 첫번째 img 태그에서 썸네일을 추출
		Iterator<PostVO> it = posts.iterator();
		PostVO postVO;
		String content;
		String thumbnail;
		Element imageElement;
		Document doc;
		while(it.hasNext()) {
			postVO=it.next();
			content=postVO.getPost_content();
			doc=Jsoup.parse(content);
			imageElement = doc.select("img").first();
			if(imageElement!=null) {
				thumbnail = imageElement.attr("src");
			}
			else {
				thumbnail="resources/images/test2.jpg";
			}
			postVO.setPost_thumbnail(thumbnail);
		}
		
		// 저장된 포스트를 posts 에 저장
		model.addAttribute("posts",posts);
		
		return "community/recommendMain";
	}
	
	
	// 상품추천 글 상세페이지로 가기
	@RequestMapping(value = "recommendDetail", method = RequestMethod.GET)
	public String recommandDetail(Model model,HttpServletRequest request) {
		
		String post_code = (String)request.getParameter("post_code");
		PostVO postVO = postService.detailPost(post_code);
		ArrayList<ReplyVO> replys = replyService.getReplys(post_code);
		postVO.setReply_count(replys.size());
		model.addAttribute("detailPost",postVO);
		model.addAttribute("postReply",replys);
				
		return "community/recommendDetail";
	}
	
	@RequestMapping(value = "recommendModify", method = RequestMethod.GET)
	public String recommandModify(Model model,HttpServletRequest request) {
		
		String post_code = (String)request.getParameter("post_code");
		
		
		model.addAttribute("modifyPost",postService.detailPost(post_code));
		
		return "community/recommendModify";
	}
	
	// 상품추천 글쓰기로 가기
	@RequestMapping(value = "recommendWrite", method = RequestMethod.GET)
	public String recommandWrite(Model model) {
		
		
		return "redirect:/fileInitialization?board_code=bd_rec";
	}

	// 상품추천 글 데이터베이스 삽입
	@RequestMapping(value = "recommendInsert", method = RequestMethod.GET)
	public String recommandInsert(Model model,HttpServletRequest request) {
		
		PostVO postVO =new PostVO();
		
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		// 포스트 코드 생성
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		Timestamp current_date = new Timestamp(System.currentTimeMillis());
		int random=(int)(Math.random()*10000);
		String post_code="ps"+day+random;
		// 포스트 코드 생성 완료
		postVO.setPost_code(post_code);
		postVO.setPost_title(post_title);
		postVO.setPost_content(post_content);
		postVO.setP_creation_date(current_date);
		postVO.setView_num(0);
		postVO.setRecommend_num(0);
		postVO.setMember_id(((MemberVO) request.getSession().getAttribute("user")).getMember_id());
		postVO.setBoard_code("bd_rec");
		
		postService.insertPost(postVO);
		
		
		
		return "redirect: /fileInsert?post_code="+post_code;
	}
	
	// 상품추천 글쓰기 삭제
	@RequestMapping(value = "recommendDelete", method = RequestMethod.GET)
	public String recommandDelete(Model model,HttpServletRequest request) {
		String post_code = request.getParameter("post_code");
		replyService.deletePostReply(post_code);
		uploadService.deletePostUpload(post_code);
		postService.deletePost(post_code);
		return "redirect: /recommendMain";
	}
	
	
	// 상품추천 글 수정
	@RequestMapping(value = "recommendUpdate", method = RequestMethod.GET)
	public String recommandUpdate(Model model,HttpServletRequest request) {
		PostVO postVO =new PostVO();
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		String post_code = (String)request.getParameter("post_code");
		postVO.setPost_title(post_title);
		postVO.setPost_content(post_content);
		postVO.setPost_code(post_code);
		
		postService.modifyPost(postVO);
		
		return "redirect: /recommendMain";
	}
	
	
	
	
	
	
	
	
	
	
	//자유게시판 메인페이지로 가기
	@RequestMapping(value = "libertyMain", method = RequestMethod.GET)
	public String libertyMain(Model model) {
		
		model.addAttribute("posts",postService.getPosts("bd_lib"));
		return "community/libertyMain";
	}
	
	// 자유게시판 글쓰기로 가기
		@RequestMapping(value = "libertyWrite", method = RequestMethod.GET)
		public String libertyWrite(Model model) {
			return "community/libertyWriteForm";
		}
	
	//대기오염물질 메인페이지로 가기
	@RequestMapping(value = "metterMain", method = RequestMethod.GET)
	public String metterMain(Model model) {
		return "community/metterMain";
	}
	
	//공기질 향상방법 메인페이지로 가기
	@RequestMapping(value = "improveMain", method = RequestMethod.GET)
	public String improveMain(Model model) {
		return "community/improveMain";
	}
	
	//건강지킴이 메인페이지로 가기
	@RequestMapping(value = "healthMain", method = RequestMethod.GET)
	public String healthMain(Model model) {
		return "community/healthMain";
	}
	
}

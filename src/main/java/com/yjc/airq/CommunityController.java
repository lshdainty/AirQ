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

import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PostVO;
import com.yjc.airq.service.PostService;

import lombok.AllArgsConstructor;

/**
 * 커뮤니티 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class CommunityController {
	
	private PostService postService;
	
	//상품추천 메인페이지로 가기
	@RequestMapping(value = "recommendMain", method = RequestMethod.GET)
	public String recommendMain(Model model) {
		ArrayList<PostVO> posts=postService.getPosts();
		Iterator<PostVO> it = posts.iterator();
		PostVO postVO;
		String content;
		String thumbnail;
		Element imageElement;
		Document doc;
		while(it.hasNext()) {
			postVO=it.next();
			System.out.println("postVO:"+postVO);
			content=postVO.getPost_content();
			System.out.println("Content:"+content);
			doc=Jsoup.parse(content);
			System.out.println("Doc:"+doc);
			imageElement = doc.select("img").first();
			if(imageElement!=null) {
				System.out.println("ImageElement:"+imageElement);
				thumbnail = imageElement.attr("src");
				System.out.println("Thumbnail:"+thumbnail);
			}
			else {
				thumbnail="resources/images/test2.jpg";
			}
			postVO.setPost_thumbnail(thumbnail);
		}
		System.out.println(posts);
		
		
		model.addAttribute("posts",posts);
		return "community/recommendMain";
	}
	
	
	// 상품추천 글 상세페이지로 가기
	@RequestMapping(value = "recommendDetail", method = RequestMethod.GET)
	public String recommandDetail(Model model,HttpServletRequest request) {
		
		String post_code = (String)request.getParameter("post_code");
		
		
		model.addAttribute("detailpost",postService.detailPost(post_code));
		System.out.println(post_code);
		return "community/recommendDetail";
	}
	
	@RequestMapping(value = "recommendModify", method = RequestMethod.GET)
	public String recommandModify(Model model,HttpServletRequest request) {
		
		String post_code = (String)request.getParameter("post_code");
		
		
		model.addAttribute("modifyPost",postService.detailPost(post_code));
		System.out.println(post_code);
		return "community/recommendModify";
	}
	
	// 상품추천 글쓰기로 가기
	@RequestMapping(value = "recommendWrite", method = RequestMethod.GET)
	public String recommandWrite(Model model) {
		return "community/recommendWriteForm";
	}
	
	// 상품추천 글 데이터베이스 삽입
	@RequestMapping(value = "recommendInsert", method = RequestMethod.GET)
	public String recommandInsert(Model model,HttpServletRequest request) {
		
		PostVO postVO =new PostVO();
		
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		Timestamp current_date = new Timestamp(System.currentTimeMillis());
		int random=(int)(Math.random()*10000);
		String post_code="ps"+day+random;
		
		postVO.setPost_code(post_code);
		postVO.setPost_title(post_title);
		postVO.setPost_content(post_content);
		postVO.setP_creation_date(current_date);
		postVO.setView_num(0);
		postVO.setRecommend_num(0);
		postVO.setMember_id(((MemberVO) request.getSession().getAttribute("user")).getMember_id());
		postVO.setBoard_code("test");
		
		postService.insertPost(postVO);
		
		
		
		return "redirect: /recommendMain";
	}
	
	// 상품추천 글쓰기 삭제
	@RequestMapping(value = "recommendDelete", method = RequestMethod.GET)
	public String recommandDelete(Model model,HttpServletRequest request) {
		String post_code = (String)request.getParameter("post_code");
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

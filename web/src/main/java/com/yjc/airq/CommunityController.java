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
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.domain.Criteria;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PostVO;
import com.yjc.airq.domain.ReplyVO;
import com.yjc.airq.domain.UploadVO;
import com.yjc.airq.service.CommunityService;
import com.yjc.airq.service.MypageService;
import com.yjc.airq.service.UploadService;

import lombok.AllArgsConstructor;

/**
 * 커뮤니티 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class CommunityController {
	
	private CommunityService postService;
	private UploadService uploadService;
	private MypageService mypageService;
	private final static String IP_ADDRESS = "http://39.127.7.69/";
	//테이블 형식 레이아웃 메인페이지
	@RequestMapping(value = "tableBoardMain", method = RequestMethod.GET)
	public String tableBoardMain(Model model,HttpServletRequest request) {
		String board_code =request.getParameter("board_code");
		
		Criteria criteria = new Criteria();
		
		int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		criteria.setTotalcount(postService.postCount(board_code));	//전체 게시글 개수를 지정
		criteria.setPagenum(pagenum);	//현재 페이지를 페이지 객체에 지정
		criteria.setStartnum(pagenum);	//컨텐츠 시작 번호 지정
		criteria.setEndnum(pagenum);	//컨텐츠 끈 번호 지정 
		criteria.setCurrentblock(pagenum);	//현재 페이지 블록이 몇번인지 현재 페이지 번호 통해 지정
		criteria.setLastblock(criteria.getTotalcount());	//마지막 블록 번호를 전체 게시글 수를 통해 정함
		criteria.prevnext(pagenum);	//현재 페이지 번호로 화살표를 나타낼지 정함
		criteria.setStartPage(criteria.getCurrentblock());	//시작 페이지를 페이지 블록번호로 정함
		criteria.setEndPage(criteria.getLastblock(),criteria.getCurrentblock());	//마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록으로 정함
		
		// 데이터베이스에서 모든 포스트를 불러옴
		ArrayList<PostVO> posts=postService.getPosts(criteria.getStartnum(),criteria.getEndnum(),board_code);
		
		Iterator<PostVO> it = posts.iterator();
		ArrayList<ReplyVO> replys = new ArrayList<ReplyVO>();
		PostVO postVO;
		String content;
		Elements content_text;
		Document doc;
		while(it.hasNext()) {
			postVO=it.next();
			replys = postService.getReplys(postVO.getPost_code());
			postVO.setReply_count(replys.size());
			content=postVO.getPost_content();
			doc=Jsoup.parse(content);
			content_text = doc.select("p");
			postVO.setPost_content(content_text.text());
		}

		model.addAttribute("posts",posts);
		model.addAttribute("criteria",criteria);
		
		request.getSession().setAttribute("board_code",board_code);
		request.getSession().setAttribute("board_type","table");
		request.getSession().setAttribute("pagenum",pagenum);
		
		return "community/tableBoardMain";
	}
	
	//썸네일 게시판 메인
	@RequestMapping(value = "thumbnailBoardMain", method = RequestMethod.GET)
	public String thumbnailBoardMain(Model model,HttpServletRequest request) {
		String board_code =request.getParameter("board_code");
			
		Criteria criteria = new Criteria();
			
		int pagenum = Integer.parseInt(request.getParameter("pagenum"));
		criteria.setTotalcount(postService.postCount(board_code));	//전체 게시글 개수를 지정
		criteria.setContentnum(9);
		criteria.setPagenum(pagenum);	//현재 페이지를 페이지 객체에 지정
		criteria.setStartnum(pagenum);	//컨텐츠 시작 번호 지정
		criteria.setEndnum(pagenum);	//컨텐츠 끈 번호 지정 
		criteria.setCurrentblock(pagenum);	//현재 페이지 블록이 몇번인지 현재 페이지 번호 통해 지정
		criteria.setLastblock(criteria.getTotalcount());	//마지막 블록 번호를 전체 게시글 수를 통해 정함
		criteria.prevnext(pagenum);	//현재 페이지 번호로 화살표를 나타낼지 정함
		criteria.setStartPage(criteria.getCurrentblock());	//시작 페이지를 페이지 블록번호로 정함
		criteria.setEndPage(criteria.getLastblock(),criteria.getCurrentblock());	//마지막 페이지를 마지막 페이지 블록과 현재 페이지 블록으로 정함
			
		/*
		 * System.out.println("TotalCount:"+criteria.getTotalcount());
		 * System.out.println("PageNum:"+criteria.getPagenum());
		 * System.out.println("StartNum:"+criteria.getStartnum());
		 * System.out.println("EndNum:"+criteria.getEndnum());
		 * System.out.println("Currentblock:"+criteria.getCurrentblock());
		 * System.out.println("LastBlock:"+criteria.getLastblock());
		 * System.out.println("PreventNext:"+criteria.isPrev());
		 * System.out.println("Next:"+criteria.isNext());
		 * System.out.println("StartPaget:"+criteria.getStartPage());
		 * System.out.println("EndPage:"+criteria.getEndPage());
		 */
			
			
		// 데이터베이스에서 모든 포스트를 불러옴
		ArrayList<PostVO> posts=postService.getPosts(criteria.getStartnum(),criteria.getEndnum(),board_code);
			
		// 불러온 포스트 중의 컨텐츠에서 첫번째 img 태그에서 썸네일을 추출
		Iterator<PostVO> it = posts.iterator();
		ArrayList<ReplyVO> replys = new ArrayList<ReplyVO>();
		PostVO postVO;
		String content;
		String thumbnail;
		Element imageElement;
		Document doc;
		while(it.hasNext()) {
			postVO=it.next();
			replys = postService.getReplys(postVO.getPost_code());
			postVO.setReply_count(replys.size());
			content=postVO.getPost_content();
			doc=Jsoup.parse(content);
			imageElement = doc.select("img").first();
			if(imageElement!=null) {
				thumbnail = imageElement.attr("src");
			}else {
				thumbnail="resources/images/test2.jpg";
			}
			
			postVO.setPost_thumbnail(thumbnail);
		}
			
		// 저장된 포스트를 posts 에 저장
		model.addAttribute("posts",posts);
		model.addAttribute("criteria",criteria);
			
		request.getSession().setAttribute("board_code",board_code);
		request.getSession().setAttribute("board_type","thumbnail");
		request.getSession().setAttribute("pagenum",pagenum);
		return "community/thumbnailBoardMain";
	}
	
	@RequestMapping(value = "replyDelete", method = RequestMethod.POST)
	@ResponseBody
	public void replyDelete(String reply_code ,String post_code) {
		
		postService.replyDelete(reply_code);
		
	}
	
	// 댓글 추가
	@RequestMapping(value = "addReply", method = RequestMethod.POST)
	@ResponseBody
	public ReplyVO addReply(ReplyVO replyVO,Model model,HttpServletRequest request) {
		// 댓글 코드 생성
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		String random=String.format("%04d",(int)(Math.random()*10000));
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
		postService.insertReply(replyVO);

		return replyVO;
	}
	
	// 글 추천
	@RequestMapping(value = "postVote", method = RequestMethod.POST)
	@ResponseBody
	public String postVote(Model model ,String post_code) {
		
		postService.postVote(post_code);
		
		return "success";
	}
	
	// 글 상세
	@RequestMapping(value = "postDetail", method = RequestMethod.GET)
	public String recommandDetail(Model model,HttpServletRequest request) {
		
		String post_code = (String)request.getParameter("post_code");
		PostVO postVO = postService.detailPost(post_code);
		ArrayList<ReplyVO> replys = postService.getReplys(post_code);
		postVO.setReply_count(replys.size());
		model.addAttribute("detailPost",postVO);
		model.addAttribute("postReply",replys);
				
		return "community/postDetail";
	}
	
	// 글 수정
	@RequestMapping(value = "postModify", method = RequestMethod.GET)
	public String recommandModify(Model model,HttpServletRequest request) {
		
		String post_code = (String)request.getParameter("post_code");
		
		model.addAttribute("modifyPost",postService.detailPost(post_code));
		
		return "community/postModify";
	}
	
	//  글 쓰기
	@RequestMapping(value = "postWrite", method = RequestMethod.GET)
	public String recommandWrite(Model model,HttpServletRequest request) {	
		
		return "community/postWriteForm";
	}

	// 글 추가
	@RequestMapping(value = "postInsert", method = RequestMethod.GET)
	public String recommandInsert(Model model,HttpServletRequest request) {
		
		PostVO postVO = new PostVO();
		UploadVO uploadVO = new UploadVO();
		
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		// 포스트 코드 생성
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		Timestamp current_date = new Timestamp(System.currentTimeMillis());
		String random=String.format("%04d",(int)(Math.random()*10000));
		String post_code="ps"+day+random;
		// 포스트 코드 생성 완료
		String board_code = (String)request.getSession().getAttribute("board_code");
		postVO.setPost_code(post_code);
		postVO.setPost_title(post_title);
		postVO.setPost_content(post_content);
		postVO.setP_creation_date(current_date);
		postVO.setView_num(0);
		postVO.setRecommend_num(0);
		postVO.setMember_id(((MemberVO) request.getSession().getAttribute("user")).getMember_id());
		postVO.setBoard_code(board_code);
		
		postService.insertPost(postVO);
		
		Document doc = Jsoup.parse(request.getParameter("post_content"));
		Elements imageElement = doc.select("img");
		String image_name[] = new String[imageElement.size()];
		for(int i=0; i<imageElement.size(); i++) {
			random=String.format("%04d",(int)(Math.random()*10000));
			String upload_code = "ul"+day+random;
			image_name[i] = imageElement.get(i).attr("src");
			uploadVO.setUpload_code(upload_code);
			uploadVO.setOriginal_name(image_name[i].substring(image_name[i].lastIndexOf("/")+33));
			uploadVO.setFile_name(image_name[i].substring(image_name[i].lastIndexOf("/")+1));
			uploadVO.setPost_code(post_code);
			uploadService.imgUpload(uploadVO);
		}
		
		String board_type = (String)request.getSession().getAttribute("board_type");
		if(board_type=="table")
			return "redirect: /tableBoardMain?board_code="+board_code+"&pagenum=1";
		else
			return "redirect: /thumbnailBoardMain?board_code="+board_code+"&pagenum=1";
	}
	
	//  글 삭제
	@RequestMapping(value = "postDelete", method = RequestMethod.GET)
	public String recommandDelete(Model model,HttpServletRequest request) {
		String post_code = request.getParameter("post_code");
		int pagenum = (int) request.getSession().getAttribute("pagenum");
		postService.deletePostReply(post_code);
		uploadService.deletePostUpload(post_code);
		postService.deletePost(post_code);
		mypageService.reportUpdate(post_code);
		String board_type = (String)request.getSession().getAttribute("board_type");
		String board_code = (String)request.getSession().getAttribute("board_code");
		System.out.println("DELETE");
		if(board_type=="table")
			return "redirect: /tableBoardMain?board_code="+board_code+"&pagenum="+pagenum;
		else
			return "redirect: /thumbnailBoardMain?board_code="+board_code+"&pagenum="+pagenum;
	}
	
	
	//  글 수정
	@RequestMapping(value = "postUpdate", method = RequestMethod.GET)
	public String recommandUpdate(Model model,HttpServletRequest request) {
		int pagenum = (int) request.getSession().getAttribute("pagenum");

		
		String board_type = (String)request.getSession().getAttribute("board_type");
		String board_code = (String)request.getSession().getAttribute("board_code");
		
		
		PostVO postVO =new PostVO();
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		String post_code = (String)request.getParameter("post_code");
		String random=String.format("%04d",(int)(Math.random()*10000));
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		
		
		postVO.setPost_title(post_title);
		uploadService.deletePostUpload(post_code);
		Document doc = Jsoup.parse(post_content);
		Elements imageElement = doc.select("img");
		String image_name[] = new String[imageElement.size()];
		UploadVO uploadVO = new UploadVO();
		for(int i=0; i<imageElement.size(); i++) {
			imageElement.get(i).attr("src",(imageElement.get(i).attr("src")).replace(IP_ADDRESS,""));
			random=String.format("%04d",(int)(Math.random()*10000));
			String upload_code = "ul"+day+random;
			image_name[i] = imageElement.get(i).attr("src");
			uploadVO.setUpload_code(upload_code);
			uploadVO.setOriginal_name(image_name[i].substring(image_name[i].lastIndexOf("/")+33));
			uploadVO.setFile_name(image_name[i].substring(image_name[i].lastIndexOf("/")+1));
			uploadVO.setPost_code(post_code);
			uploadService.imgUpload(uploadVO);
		}
		postVO.setPost_content(doc.select("body").toString().replace("<body>","").replace("</body>",""));
		postVO.setPost_code(post_code);
		System.out.println(postVO);
		postService.modifyPost(postVO);
		
		
		
		if(board_type=="table")
			return "redirect: /tableBoardMain?board_code="+board_code+"&pagenum="+pagenum;
		else
			return "redirect: /thumbnailBoardMain?board_code="+board_code+"&pagenum="+pagenum;
	}
}

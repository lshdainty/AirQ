 package com.yjc.airq.app;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjc.airq.domain.Criteria;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.PostVO;
import com.yjc.airq.domain.ReplyVO;
import com.yjc.airq.domain.UploadVO;
import com.yjc.airq.service.CommunityService;
import com.yjc.airq.service.UploadService;

import lombok.AllArgsConstructor;
import net.sf.json.JSONObject;

/**
 * 커뮤니티 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class mobileCommunityController {
	
	private CommunityService postService;
	private UploadService uploadService;
	private final static String IP_ADDRESS = "http://39.127.7.69/";
	//테이블 형식 레이아웃 메인페이지
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "m.getPosts", method = RequestMethod.GET)
	public JSONObject tableBoardMain(Model model,HttpServletRequest request) {
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

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pList", posts);
		map.put("criteria", criteria);
		JSONObject json = JSONObject.fromObject(map);
		return json;
	}
	
	//상품상세
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "m.postDetail", method = RequestMethod.GET)
	public JSONObject recommandDetail(Model model,HttpServletRequest request) {
		
		String post_code = request.getParameter("post_code");
		PostVO postVO = postService.detailPost(post_code);
		ArrayList<ReplyVO> replys = postService.getReplys(post_code);
		postVO.setReply_count(replys.size());
		Elements imageElements;
		Document doc;
		doc=Jsoup.parse(postVO.getPost_content());
		if(doc.select("img")!=null) {
			imageElements = doc.select("img");
			for(int i=0; i <imageElements.size(); i++) {
				imageElements.get(i).attr("src",IP_ADDRESS+imageElements.get(i).attr("src"));
			}
		}
		postVO.setPost_content(doc.select("body").toString());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("detailPost", postVO);
		map.put("replys", replys);
		JSONObject json = JSONObject.fromObject(map);
		return json;
				
	}
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "m.postInsert", method = RequestMethod.GET)
	public void recommandInsert(Model model,HttpServletRequest request) {
		
		PostVO postVO = new PostVO();
		UploadVO uploadVO = new UploadVO();
		
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		String member_id = request.getParameter("member_id");
		String board_code = request.getParameter("board_code");
		// 포스트 코드 생성
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
		String day = date.format(today);
		Timestamp current_date = new Timestamp(System.currentTimeMillis());
		String random=String.format("%04d",(int)(Math.random()*10000));
		String post_code="ps"+day+random;
		// 포스트 코드 생성 완료
		postVO.setPost_code(post_code);
		postVO.setPost_title(post_title);
		postVO.setPost_content(post_content);
		postVO.setP_creation_date(current_date);
		postVO.setView_num(0);
		postVO.setRecommend_num(0);
		postVO.setMember_id(member_id);
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
	}
	
	@RequestMapping(value = "m.postVote", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	@ResponseBody
	public String postVote(Model model ,@RequestParam("post_code") String post_code) {
		postService.postVote(post_code);
		
		return "success";
	}
	
	
	// 댓글 추가
		@CrossOrigin(origins = "*")
		@RequestMapping(value = "m.addReply", method = RequestMethod.POST)
		@ResponseBody
		public ReplyVO addReply(HttpServletRequest request) {
			// 댓글 코드 생성
			ReplyVO replyVO = new ReplyVO();
			Date today = new Date();
			SimpleDateFormat date = new SimpleDateFormat("yyMMdd");
			String day = date.format(today);
			String random=String.format("%04d",(int)(Math.random()*10000));
			String reply_code="rp"+day+random;
			// 댓글 코드 생성 완료
			String reply_content = request.getParameter("reply_content");
			Timestamp r_creation_date = new Timestamp(System.currentTimeMillis());
//			String member_id = ((MemberVO) request.getSession().getAttribute("user")).getMember_id();
	    	String product_code=request.getParameter("product_code");
	    	String post_code=request.getParameter("post_code");
	    	
		    if(product_code==null)
		    	product_code="";
		    if(post_code==null)
		    	post_code="";
		    	
			replyVO.setReply_code(reply_code);
			replyVO.setReply_content(reply_content);
			replyVO.setR_creation_date(r_creation_date);
			replyVO.setMember_id("test");// 로그인 완료 후 다시 작성
			replyVO.setPost_code(post_code);
			replyVO.setProduct_code(product_code);
			postService.insertReply(replyVO);
			return replyVO;
		}
		
		// 글 수정
		@CrossOrigin(origins = "*")
		@ResponseBody
		@RequestMapping(value = "m.postModify", method = RequestMethod.GET)
		public JSONObject recommandModify(Model model,HttpServletRequest request) {
			
			String post_code = (String)request.getParameter("post_code");
			PostVO postVO = postService.detailPost(post_code);
			Elements imageElements;
			Document doc;
			doc=Jsoup.parse(postVO.getPost_content());
			if(doc.select("img")!=null) {
				imageElements = doc.select("img");
				for(int i=0; i <imageElements.size(); i++) {
					imageElements.get(i).attr("src",IP_ADDRESS+imageElements.get(i).attr("src"));
				}
			}
			postVO.setPost_content(doc.select("body").toString());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("modifyPost", postVO);
			JSONObject json = JSONObject.fromObject(map);
			return json;
		}
		@CrossOrigin(origins = "*")
		@ResponseBody
		@RequestMapping(value = "m.postUpdate", method = RequestMethod.GET)
		public void recommandUpdate(Model model,HttpServletRequest request) {
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
		}
		
		
		@CrossOrigin(origins = "*")
		@ResponseBody
		@RequestMapping(value = "m.postDelete", method = RequestMethod.GET)
		public String recommandDelete(Model model,HttpServletRequest request) {
			String post_code = request.getParameter("post_code");
			System.out.println(post_code);
			postService.deletePostReply(post_code);
			uploadService.deletePostUpload(post_code);
			postService.deletePost(post_code);
			
			return "success";
		}
}

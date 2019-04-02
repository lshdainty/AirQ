package com.yjc.airq;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yjc.airq.service.BoardService;

import lombok.AllArgsConstructor;

/**
 * 커뮤니티 서비스를 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class CommunityController {
	
	private BoardService board;
	
	//상품추천 메인페이지로 가기
	@RequestMapping(value = "recommendMain", method = RequestMethod.GET)
	public String recommendMain(Model model) {
		
		model.addAttribute("boards",board.getBoards());
		return "community/recommendMain";
	}
	
	// 상품추천 글쓰기로 가기
	@RequestMapping(value = "recommendDetail", method = RequestMethod.GET)
	public String recommandDetail(Model model,HttpServletRequest request) {
		
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		
		model.addAttribute("detailBoard",board.detailBoard(board_id));
		System.out.println(board_id);
		return "community/recommendDetail";
	}
	
	
	// 상품추천 글쓰기로 가기
	@RequestMapping(value = "recommendWrite", method = RequestMethod.GET)
	public String recommandWrite(Model model) {
		return "community/recommendWriteForm";
	}
	
	// 상품추천 글 데이터베이스 삽입
	@RequestMapping(value = "recommendInsert", method = RequestMethod.GET)
	public String recommandInsert(Model model) {
		return "community/recommendMain";
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

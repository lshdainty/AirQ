package com.yjc.airq;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yjc.airq.domain.BoardVO;
import com.yjc.airq.domain.MemberVO;
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
	
	
	// 상품추천 글 상세페이지로 가기
	@RequestMapping(value = "recommendDetail", method = RequestMethod.GET)
	public String recommandDetail(Model model,HttpServletRequest request) {
		
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		
		model.addAttribute("detailBoard",board.detailBoard(board_id));
		System.out.println(board_id);
		return "community/recommendDetail";
	}
	
	@RequestMapping(value = "recommendModify", method = RequestMethod.GET)
	public String recommandModify(Model model,HttpServletRequest request) {
		
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		
		
		model.addAttribute("modifyBoard",board.detailBoard(board_id));
		System.out.println(board_id);
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
		
		BoardVO boardVO =new BoardVO();
		
		String board_content = request.getParameter("board_content");
		String board_name = request.getParameter("board_name");
		
		
		boardVO.setBoard_name(board_name);
		boardVO.setBoard_content(board_content);
		boardVO.setBoard_author( ((MemberVO) request.getSession().getAttribute("user")).getPassword());
		
		board.insertBoard(boardVO);
		
		
		
		return "redirect: /recommendMain";
	}
	
	// 상품추천 글쓰기 삭제
	@RequestMapping(value = "recommendDelete", method = RequestMethod.GET)
	public String recommandDelete(Model model,HttpServletRequest request) {
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		board.deleteBoard(board_id);
		return "redirect: /recommendMain";
	}
	
	
	// 상품추천 글 수정
	@RequestMapping(value = "recommendUpdate", method = RequestMethod.GET)
	public String recommandUpdate(Model model,HttpServletRequest request) {
		BoardVO boardVO =new BoardVO();
		String board_name = request.getParameter("board_name");
		String board_content = request.getParameter("board_content");
		int board_id=Integer.parseInt(request.getParameter("board_id"));
		System.out.println("Name:"+board_name);
		System.out.println("Content:"+board_content);
		System.out.println("ID:"+board_id);
		boardVO.setBoard_name(board_name);
		boardVO.setBoard_content(board_content);
		boardVO.setBoard_id(board_id);
		board.modifyBoard(boardVO);
		
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

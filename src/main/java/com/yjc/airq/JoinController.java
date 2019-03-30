package com.yjc.airq;

import java.io.File;
import java.util.Locale;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.yjc.airq.domain.FileTestVO;
import com.yjc.airq.JoinController;
import com.yjc.airq.domain.MemberVO;
import com.yjc.airq.domain.SellerVO;
import com.yjc.airq.service.JoinService;

import lombok.AllArgsConstructor;

/**
 * 회원가입을 관리하는 controller
 */
@Controller
@AllArgsConstructor
public class JoinController {
	private JoinService joinService;

	// 회원가입 메인페이지로 가기
	@RequestMapping(value = "joinMain", method = RequestMethod.GET)
	public String joinMain(Model model) {
		return "join/joinMain";
	}

	// 일반 사용자 회원가입 이동
	@RequestMapping(value = "/nRegister", method = RequestMethod.GET)
	public String nRegister(Locale locale, Model model) {

		return "join/nRegister";
	}

	// 판매자 회원가입 이동
	@RequestMapping(value = "/sRegister", method = RequestMethod.GET)
	public String sRegister(Locale locale, Model model) {

		return "join/sRegister";
	}

	// 회원 가입
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(Model model, MemberVO mb) {

		System.out.println("회원가입 id: " + mb.getId());
		System.out.println("회원가입 pw: " + mb.getPassword());
		System.out.println("Name: " + mb.getName());
		System.out.println("E-mail: " + mb.getEmail());
		System.out.println("Tel: " + mb.getTel());
		System.out.println("Address: " + mb.getAddress());
		
		// nRegister.jsp로 부터 받은 회원정보 들을 DB저장
		joinService.signup(mb);

		return "login/loginMain";
	}

	// (회원가입)사업자 등록번호 DB insert
	@RequestMapping(value = "Bsignup", method = RequestMethod.GET)
	public String Bsignup(Model model, SellerVO sl) {

		System.out.println("사업자 등록 번호: " + sl.getBnumber());
		joinService.sellerList(sl);

		return "login/loginMain";
	}

	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public String postIdCheck(Model model, HttpServletRequest req) {

		String id = req.getParameter("id");
		MemberVO idCheck = joinService.idCheck(id);

		if (idCheck != null) {
			return "No";
		}
		return "Yes";
	}

	// 버튼 테스트
	@RequestMapping(value = "/ButtonTest", method = RequestMethod.GET)
	public String ButtonTest(Locale locale, Model model) {

		return "ButtonTest";
	}

	// 파일 업로드
	
	// xml에 설정된 리소스 참조
	// bean의 id가 uploadPath인 태그를 참조
	@Resource(name = "uploadPath")
	String uploadPath;

	// 업로드 흐름 : 업로드 버튼 클릭 -> 임시 디렉토리에 업로드 -> 지정된 디렉토리에 저장 -> 파일정보가 file에 저장
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public void uploadForm() {
		// upload/uploadForm.jsp(업로드 페이지)로 포워딩
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView uploadForm(MultipartFile file, ModelAndView mav, MemberVO mb) throws Exception {

		String saveName = file.getOriginalFilename();

		File target = new File(uploadPath, saveName);
		// 임시 디렉토리에 저장된 업로드된 파일을 지정된 디렉토리로 복사 //FileCopyUtils.copy(바이트배열, 파일객체)
		FileCopyUtils.copy(file.getBytes(), target);

		mav.setViewName("login/loginMain"); // 회원가입 후 이동경로

		// 고유ID 랜덤 생성
		String uuid = UUID.randomUUID().toString().replace("-", "");

		String filename = file.getOriginalFilename() + uuid;
		String oriname = file.getOriginalFilename();
		String path = "\\resources\\images";

		FileTestVO fDB = new FileTestVO();
		fDB.setFilename(filename);
		fDB.setOriname(oriname);
		fDB.setPath(path);
		joinService.fileDB(fDB);
		

		// sRegister.jsp로 부터 받은 회원정보 들을 DB저장
		joinService.signup(mb);

		return mav; // login/loginMain.jsp(결과화면)로 포워딩
	}
}

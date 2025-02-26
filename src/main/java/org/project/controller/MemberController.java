package org.project.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.project.domain.LikeVO;
import org.project.domain.MemberVO;
import org.project.service.LikeService;
import org.project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@Service
@RequestMapping("/join/*")
public class MemberController {
	@Autowired
	private MemberService service;
	@Autowired
	private LikeService likeservice;
	@GetMapping("/login")
	public void login(@RequestHeader(value = "Referer", required = false) String referrer, HttpSession session) {
	    if (referrer != null && !referrer.isEmpty()) {
	        // 이전 페이지의 URL을 세션에 저장
	        session.setAttribute("prevPage", referrer);
	    }
	}

	@PostMapping("/login")
	public String login(MemberVO membervo, HttpSession session, RedirectAttributes rttr) {
		log.info("login post, Id -> " + membervo.getId());
		String checkId = service.login(membervo.getId(), membervo.getPw());
		List<LikeVO> likeList = likeservice.getLike(membervo.getId());
	    session.setAttribute("likeList", likeList);
		if (checkId != null && checkId.equals(membervo.getId())) {
		    session.setAttribute("id", checkId);
		    log.info(checkId + "->main");
	        // 이전 페이지의 URL을 가져옴
	        String prevPage = (String) session.getAttribute("prevPage");
	        if (prevPage != null) {
	            // 이전 페이지로 리다이렉션
	            session.removeAttribute("prevPage");
//	            만약 마이페이지에서 로그인하면 마이페이지로 갈거야
//	            if(prevPage =="http://localhost:8080/page/main")
//	            {
//	            	return "redirect:/page/mypage";
//	            }
	            return "redirect:" + prevPage;
	        } else {
	            return "redirect:/page/main";
	        }
		}
		rttr.addFlashAttribute("result", checkId);
		log.info(checkId+"->login");
		return "redirect:/join/login";
	}

	@RequestMapping(value = "join/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session,@RequestHeader(value = "Referer", required = false)String referrer) {
	    if (referrer != null && !referrer.isEmpty()) {
	        // 이전 페이지의 URL을 세션에 저장
	        session.setAttribute("prevPage", referrer);
	        String prevPage = (String) session.getAttribute("prevPage");
	        if (prevPage != null) {
	            // 이전 페이지로 리다이렉션
	            session.removeAttribute("prevPage");
	            session.invalidate();
	            log.info("logout");
//	            만약 마이페이지에서 로그아웃하면 로그인 페이지로 갈거야
//	            if(prevPage =="http://localhost:8080/page/main")
//	            {
//	            	return "redirect:/join/login";
//	            }
	            return "redirect:" + prevPage;
	        }	        
	    }
	    session.invalidate();
	    log.info("logout");
	    return "redirect:/page/main";
	}


	@GetMapping("id_find")
	public void findId() {
		log.info("id_find Get");
	}
	
	@PostMapping("id_find")
	public String findId(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("phone") String phone, Model model) {
		// MemberService를 호출하여 아이디 찾기 로직 수행
        String foundId = service.findId(name, email, phone);

        if (foundId != null) {
        	model.addAttribute("message", "아이디는 " + foundId + " 입니다.");
            model.addAttribute("foundId", foundId);
        } else {
        	model.addAttribute("message", "일치하는 아이디를 찾을 수 없습니다.");
        }

        return "id_find_result"; // 결과를 표시할 JSP 파일의 이름 반환
    }
	@GetMapping("id_find_result")
	public void findIdResult() {
		log.info("id_find_Result Get");
	}
	
	@GetMapping("pw_find")
	public void findPw() {
		log.info("pw_find Get");
	}

	
	@PostMapping("pw_find")
	public String findPw(
			@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("checked") int checked,
			@RequestParam("phone") String phone, Model model) {
		// MemberService를 호출하여 아이디 찾기 로직 수행
        String foundPw = service.findPw(id, name, email, phone);

        if (foundPw != null) {
            model.addAttribute("message", "비밀번호는 " + foundPw + " 입니다.");
            model.addAttribute("foundPw", foundPw);
        } else {
            model.addAttribute("message", "일치하는 비밀번호를 찾을 수 없습니다.");
        }

        return "/join/pw_find_result"; // 결과를 표시할 JSP 파일의 이름 반환
    }
	
	@GetMapping("register")
	public void register() {
		log.info("register Get");
	}
	
	@PostMapping("/register")
	public String register(MemberVO membervo, RedirectAttributes rttr) {
		log.info("register ->" + membervo);
		boolean IDChk;
		boolean EChk;
		IDChk = service.registerIdCheck(membervo.getId());
		EChk = service.registerEmailCheck(membervo.getEmail());
		if (IDChk == false) {
			rttr.addFlashAttribute("result", "중복된 ID");
			return "redirect:/join/register";
		}
		else if (EChk == false) {
			rttr.addFlashAttribute("result", "중복된 EMAIL");
			return "redirect:/join/register";
		}

		service.register(membervo);
		rttr.addFlashAttribute("result", "회원가입 완료");
		// redirect login
		return "redirect:/join/login";
	}
	
	

}
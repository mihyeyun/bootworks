package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.boot.domain.Member;
import com.boot.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@SessionAttributes("member") //'member' 세션 유지
@Slf4j
@Controller
public class LoginController {
	
	@Autowired
	private MemberService service;
	
	//로그인 페이지 요청
	@GetMapping("/login")
	public String loginView() {
		log.info("login 페이지 진입");
		return "login";
	}
	
	//로그인 인증 처리
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member findMember = service.getMember(member);	//db에 저장된 객체
		//findMember의 비밀번호와 로그인 폼에 입력한 비밀번호와 비교 
		if(findMember != null && findMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member", findMember);	//세션 발급(view에 보내줌)
			return "redirect:getBoardList";
		}else {
			return "redierec:login";
		}	
	}
	
	//로그아웃 처리
	/*@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();	//모든 세션 삭제
		return "redirect:";		//경로가 공백이면 '/' 경로와 같음
	}*/
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete(); //모든 세션 삭제
		return "redirect:";		//경로가 공백이면 '/' 경로와 같음
	}
	
	//회원가입 페이지 요청
	@GetMapping("/signup")
	public String signupView() {
		return "signup";
	}
	
	//회원 가입 처리
	@PostMapping("/signup")
	public String signup(Member member) {
		service.signup(member);
		return "redirect:";
	}	
	
	//나의 정보 페이지 요청
	@GetMapping("/profile")
	public String profile(String id, Model model) {
		Member member = service.getMember(id);
		model.addAttribute("member", member);	
		return "profile";
	}
	
	//내 정보 수정하기
	/*@PostMapping("updateMember")
	public String updateMember(Member member) {
		service.updateMember(member);
		return "redirect:";		
	}*/
}
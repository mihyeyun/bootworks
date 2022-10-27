package com.shop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shop.constant.Role;
import com.shop.dto.MemberFormDto;
import com.shop.entity.Member;

import lombok.extern.slf4j.Slf4j;

//@Transactional
@Slf4j
@SpringBootTest
public class MemberServiceTests {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	PasswordEncoder pwEncoder;
	
	//회원 생성
	public Member createMember() {
		MemberFormDto memberFormDto = new MemberFormDto();
		memberFormDto.setEmail("test3@test.com");
		memberFormDto.setName("테스트");
		memberFormDto.setAddress("테스트");
		memberFormDto.setPassword("1234");
		//memberFormDto.setRole(Role.USER);
		return Member.createMember(memberFormDto, pwEncoder);
	}
	
	//회원 가입 테스트
	@Test
	public void saveMemberTest() {
		Member member = createMember();
		memberService.saveMember(member);
		log.info("회원가입 테스트 성공");
	}
	
	//이메일 중복 테스트
	/*@Test
	public void saveDuplicateMemberTest() {
		Member member1 = createMember();
		Member member2 = createMember();
		memberService.saveMember(member1);
		
		Throwable e = assertThrows(IllegalStateException.class, () -> {
			memberService.saveMember(member2);
		});
		
		assertEquals("이미 가입된 회원입니다.", e.getMessage());
	}*/
	
}

package com.boot.service;

import java.util.List;

import com.boot.domain.Member;

public interface MemberService {
	
	//로그인 처리
	Member getMember(Member member);
	
	//회원가입
	void signup(Member member);
	
	//회원 목록 가져오기
	List<Member> getMemberList();
	
	//회원 상세 보기
	Member getOne(String id);
	
	//회원 삭제
	void deleteMember(Member member);
	
	//회원 수정
	void updateMember(Member member);
}

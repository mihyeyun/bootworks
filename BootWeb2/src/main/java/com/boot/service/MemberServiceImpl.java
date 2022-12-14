package com.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.boot.domain.Member;
import com.boot.persistence.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepository memberRepo;
	
	//로그인 처리
	@Override
	public Member getMember(Member member) {
		//findById의 반환형이 Optional 임
		//Optional 클래스는 null 에러를 방지하는 클래스
		Optional<Member> findMember = memberRepo.findById(member.getId());
		if(findMember.isPresent()) {	//해당 아이디가 존재하면
			return findMember.get();	//객체를 반환
		}else {
			return null;
		}
	}

	//회원 가입
	@Override
	public void signup(Member member) {
		member.setRole("ROLE_USER"); 	//권한 설정
		memberRepo.save(member);
	}

	//회원 목록 가져오기
	@Override
	public List<Member> getMemberList() {
		return memberRepo.findAll();
	}

	//회원 상세 보기
	@Override
	public Member getOne(String id) {
		return memberRepo.findById(id).get();
	}

	//회원 삭제하기
	@Override
	public void deleteMember(Member member) {
		memberRepo.delete(member);
	}

	//회원 수정
	/*@Override
	public void updateMember(Member member) {
		Member findMember = memberRepo.findById(member.getId()).get();
		findMember.setId(member.getId());	
		findMember.setPassword(member.getPassword());	
		findMember.setName(member.getName());	

		memberRepo.save(member);
	}*/
	
	//회원 수정
	@Override
	public void updateMember(Member member) {
		memberRepo.save(member);	//가입과 수정 메소드가 같음
	}
}

package com.boot.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude="boardList") //순환참조를 하므로 boardList를 제외함
public class Member {
	
	@Id
	@Column(name="MEMBER_ID")	//기본키 이름 설정(외래키 참조 시 사용)
	private String id;
	private String password;
	private String name;
	private String role;
	
	//일대다 관계 매핑
	@OneToMany(mappedBy="member", fetch=FetchType.EAGER)
	private List<Board> boardList = new ArrayList<>();
}

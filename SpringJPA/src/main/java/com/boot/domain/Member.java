package com.boot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Member {
	
	@Id
	@Column(name="MEMBER_ID")	//기본키 이름 설정(외래키 참조 시 사용)
	private String id;
	private String password;
	private String name;
	private String role;
}

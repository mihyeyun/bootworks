package com.boot.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity  //클래스(엔티티 - 테이블 역할)
@Getter
@Setter
@ToString
public class Member {
	
	@Id //PK(Primary Key)
	private String id;
	private String password;
	private String name;
	private String role;
	
}

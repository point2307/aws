package com.recipe.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.recipe.dto.Member;


public class SecurityUser extends User {

	private static final long serialVersionUID = 1L;
	private com.recipe.dto.Member member;
	
	public SecurityUser(com.recipe.dto.Member member) {
		super(member.getMem_id(), member.getMem_password(),
				AuthorityUtils.createAuthorityList(member.getRole().toString()));
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}
	
}

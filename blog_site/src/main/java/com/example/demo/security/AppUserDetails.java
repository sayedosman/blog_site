package com.example.demo.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.Models.User;



public class AppUserDetails implements UserDetails{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	
	public AppUserDetails(User user) {
		this.user = user;
	}
	public AppUserDetails() {}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		GrantedAuthority authorty=new GrantedAuthority() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
					return user.getUsername();
				
			}
		};
		
		
		return Arrays.asList(authorty);
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	

	public User getUser() {
		return user;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

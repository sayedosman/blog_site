package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.security.AppUserDetailServise;
import com.example.demo.security.AuthFilter;




@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   private AppUserDetailServise userDetailServise;
	 @Bean
		public AuthFilter authFilter () {
			
			return new AuthFilter() ;
		}
	 
	 
	 
	   @Override
	    public void configure(WebSecurity web) {
	        web.ignoring()
	                .antMatchers(HttpMethod.OPTIONS, "/**");
	    }
	 
	 
	    @Bean()
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	    @Bean
	   public  PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	   
	    @Override
	    public void configure(HttpSecurity httpSecurity) throws Exception {
	        httpSecurity.csrf().disable()
	                .authorizeRequests()
	                .antMatchers("/api/auth/**")
	                .permitAll()
	                .antMatchers("/api/posts/all")
	                .permitAll()
	                .anyRequest()
	                .authenticated()
	                .and()
          
	        .addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);
	        
	   
	    	
	      
	        
	    }
}

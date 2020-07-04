package com.example.demo.Controller;


import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ApiPackage.User;
import com.example.demo.ApiPackage.UserLogin;
import com.example.demo.ApiPackage.UserRegister;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.security.AppUserDetails;
import com.example.demo.security.JWTResponse;
import com.example.demo.security.TokenUtiles;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	  @Autowired
	    private TokenUtiles tokenUtiles;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public JWTResponse signup(@RequestParam("username")String username, @RequestParam("password")String password)  {
    	System.out.println(username);
    	try {
    	    	Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
    	    			password));
    	    	AppUserDetails user=userService.getUserByEmail(username);
    	        String authenticationToken = tokenUtiles.generateToken(user);
    	        System.out.println(authenticationToken);
    	        return new JWTResponse(authenticationToken, username);
    	    
    	}catch (Exception e) {
    		System.out.println("dfhhdfhds");
    		return null;
    		
		}
    			
 

    	   }

    @PostMapping("/signup")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public UserRegister signup(@RequestBody UserRegister user) {
    	System.out.println(user.getPassword());
    	System.out.println(user.getConfirmPassword());
    	System.out.println(user.getUsername());
    	System.out.println(user.getEmail());
    		userService.signup(user);
    	 return user;
    	
       
    }
    @GetMapping("/get/{username}")
    @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
    public User getUser(@PathVariable("username") String username) {
    	return userService.getUser(username);
    }
 
}

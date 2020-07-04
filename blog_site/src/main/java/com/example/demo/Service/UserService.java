package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.ApiPackage.Post;
import com.example.demo.ApiPackage.User;
import com.example.demo.ApiPackage.UserRegister;
import com.example.demo.Repository.UserRepository;
import com.example.demo.security.AppUserDetails;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public User getUser(String username) {
    	 Optional<com.example.demo.Models.User>user=userRepository.findByEmail(username);
    	 com.example.demo.Models.User user2=user.get();
         return changeToUser(user2);
    }
    public AppUserDetails getUserByEmail(String username)
	{  	
    	  Optional<com.example.demo.Models.User>user= userRepository.findByEmail(username);
    	  return user.map(AppUserDetails::new).get();
    }
    
    public UserRegister signup(UserRegister registerRequest) {
       com.example.demo.Models.User user = new  com.example.demo.Models.User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        try {
        userRepository.save(user);
        return registerRequest;
        }catch (Exception e) {
        	registerRequest.setUsername("dublicate");
        	 return registerRequest;
		}
    }
	
   
    public User changeToUser( com.example.demo.Models.User user2) {
    	User user=new User();
    	
    	List<Post>posts=new ArrayList<Post>();
    	user.setId(user2.getId());
    	user.setEmail(user2.getEmail());
    	user.setUsername(user2.getUsername());
    	
    	for(com.example.demo.Models.Post  post:user2.getPosts()) {
    		Post p=new Post(post.getId(),post.getContent(),post.getTitle(),post.getCreate_on());
    		posts.add(p);
    	}
    	user.setPosts(posts);
    	return user;
    }
}

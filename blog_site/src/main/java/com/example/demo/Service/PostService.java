package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.ApiPackage.Post;
import com.example.demo.ApiPackage.User;
import com.example.demo.Repository.PostRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.security.AppUserDetails;


@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	public List<Post>getAllPosts(){
		List<com.example.demo.Models.Post>posts2=postRepository.findAll();
		 List<Post>posts=new  ArrayList<Post>();
		 for(com.example.demo.Models.Post post2:posts2) {
			 Post post=chamgeToPost(post2);
			 posts.add(post);
		 }
		 return posts;
		
	}
	
	
	public Post getPost(long  postId) {
		com.example.demo.Models.Post post=postRepository.findById(postId).get();
		return  chamgeToPost(post);
		
	}
	public List<Post> getUserPost(String  username) {
		 AppUserDetails Appuser= (AppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     	com.example.demo.Models.User user=Appuser.getUser();
     	List<Post>posts=new  ArrayList<Post>();
		 for(com.example.demo.Models.Post post2:user.getPosts()) {
			 Post post=chamgeToPost(post2);
			 posts.add(post);
		 }
		 return posts;
		
	}
	public void deletePost(long postId) {
		
		postRepository.deleteById(postId);
	}
	public Post save (Post post) {
		com.example.demo.Models.Post post2=new com.example.demo.Models.Post();
		post2.setId(post.getId());
		post2.setContent(post.getContent());
		post2.setCreate_on(post.getCreate_on());
		post2.setTitle(post.getTitle());

        	 AppUserDetails Appuser= (AppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        	com.example.demo.Models.User user=Appuser.getUser();
        	 System.out.println(user.getUsername());
         
        // AppUserDetails user= (AppUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		post2.setUser(user);
		post2.setCreate_on(new Date());
		try {
		postRepository.save(post2);
		return post;
		}catch (Exception e) {
			post.setContent("dublicate");
			return post;
			
		}
		
	}
	
	public Post chamgeToPost(com.example.demo.Models.Post post2) {
		Post post=new Post();
		post.setId(post2.getId());
		post.setContent(post2.getContent());
		post.setCreate_on(post2.getCreate_on());
		post.setTitle(post2.getTitle());
		post.setUser(new User(post2.getUser().getId(),post2.getUser().getUsername(),post2.getUser().getEmail()));
		return post;
	}
}

package com.example.demo.Controller;

import java.util.List;

import javax.persistence.PostRemove;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ApiPackage.Post;
import com.example.demo.Service.PostService;


@RestController
@RequestMapping("/api/posts")
public class PostController {
   
    @Autowired
    private PostService postService;
	@GetMapping("/all")
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<Post>getAllPosts(){
		System.out.println("welcome");
		return postService.getAllPosts();
	}
	@PostMapping("/add")
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	public Post addPost(@RequestBody Post post,HttpServletRequest request){
		 System.out.println(request.getHeader("Authorization"));
        System.out.println(post.getContent());
        System.out.println(post.getTitle());
		return postService.save(post);
	}
	@GetMapping("/get/{PostId}")
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	public Post getPost(@PathVariable("PostId")long postId) {
		System.out.println(postId);
		return postService.getPost(postId);
	}
	@GetMapping("/getUserPosts/{username}")
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	public List<Post> geUsertPost(@PathVariable("username")String username) {
		return postService.getUserPost(username);
	}
	
	@DeleteMapping("/deletepost/{postId}")
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	public void delete(@PathVariable("postId") long postId) {
		System.out.println("deleted"+postId);
		 postService.deletePost(postId);
	}
}

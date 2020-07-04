package com.example.demo.Models;

import java.util.List;

import javax.persistence.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
    private Long id;
    @Column(name="name")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
   
    
   

	 public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@OneToMany(cascade = {CascadeType.MERGE},fetch = FetchType.EAGER,mappedBy = "user")
    private List<Post>posts;
    public User() {
	}

	public User(Long id, String username, String email) {
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

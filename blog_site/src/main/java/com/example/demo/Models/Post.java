package com.example.demo.Models;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="post")
public class Post {
    
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="id")
	    private Long id;
	 @Column(name="title")
	    private String title;
	 @Column(name="content")
	 @NotEmpty
	 @Lob
	    private String content;
	 @Column(name="create_on")
	    private Date create_on;
	
	 @ManyToOne(fetch = FetchType.EAGER,cascade ={CascadeType.MERGE})
	 @JoinColumn(name="user_id")
	    private User user;
	 public Post() {}
	public Post(Long id, String title, @NotEmpty String content, Date create_on, User user) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.create_on = create_on;
		
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreate_on() {
		return create_on;
	}
	public void setCreate_on(Date create_on) {
		this.create_on = create_on;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	 
}

package com.example.demo.ApiPackage;

import java.util.Date;

public class Post {

	private Long id;
	    private String title;
	    private String content;
	    private Date create_on;
	    private User user;
		public Post() {
			
		}
		
		public Post(Long id, String title, String content, Date create_on) {
			this.id = id;
			this.title = title;
			this.content = content;
			this.create_on = create_on;
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

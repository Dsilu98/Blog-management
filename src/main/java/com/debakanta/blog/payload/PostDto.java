package com.debakanta.blog.payload;

import java.util.Date;

import com.debakanta.blog.entities.Catagory;
import com.debakanta.blog.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
	
	private int postId;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;
	private Catagory catagory;
	private User user;
	


	
}

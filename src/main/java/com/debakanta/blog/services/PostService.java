package com.debakanta.blog.services;

import java.util.List;

import com.debakanta.blog.entities.Post;
import com.debakanta.blog.payload.PostDto;
import com.debakanta.blog.payload.PostResponce;

public interface PostService {
	
	//ctrate
	PostDto createPost(PostDto postDto,Integer userId,Integer catagoryId);
	//update
	PostDto updatePost(PostDto postDto,Integer postId);
	//delete
	void deletePost(Integer postId);
	//get
	PostResponce getAllPost(Integer pageNumber,Integer pageSize);
	
	//get post by user
	List<PostDto> getPostByUSer(Integer userId);
	//get post by catagory
	List<PostDto> getPostByCatagory(Integer catagoryId);
	
	PostDto getPostByPostId(Integer postId);
	
	List<PostDto> getPostByKeyword(String keyword);
}

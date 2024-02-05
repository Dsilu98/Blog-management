package com.debakanta.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.debakanta.blog.entities.Post;
import com.debakanta.blog.payload.PostDto;
import com.debakanta.blog.payload.PostResponce;
import com.debakanta.blog.services.PostService;
import com.debakanta.blog.services.impl.PostServiceImpl;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/user/{userId}/catagory/{catagoryId}/posts")
	public ResponseEntity<PostDto> cretePost(
			@RequestBody PostDto postDto,
			@PathVariable Integer userId,
			@PathVariable Integer catagoryId){
		PostDto createPost = this.postService.createPost(postDto, userId, catagoryId);
		return new ResponseEntity(createPost,HttpStatus.CREATED);
	}
	
	@GetMapping("/catagory/{catagoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsCatagory(@PathVariable Integer catagoryId){
		
		List<PostDto> posts = this.postService.getPostByCatagory(catagoryId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		
		List<PostDto> posts = this.postService.getPostByUSer(userId);
		return ResponseEntity.ok(posts);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponce> getAllPost(
			@RequestParam (value = "pageNumber",defaultValue = "0",required = false) Integer pageNuber,
			@RequestParam (value = "pageSize",defaultValue = "10",required = false)Integer pageSize ){
			PostResponce postResponce = this.postService.getAllPost(pageNuber,pageSize);
			return ResponseEntity.ok(postResponce);
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		PostDto postDto = this.postService.getPostByPostId(postId);
		return ResponseEntity.ok(postDto);
	}

}

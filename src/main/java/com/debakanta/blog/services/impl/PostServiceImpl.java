package com.debakanta.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.debakanta.blog.entities.Catagory;
import com.debakanta.blog.entities.Post;
import com.debakanta.blog.entities.User;
import com.debakanta.blog.exceptions.ResourceNotFoundException;
import com.debakanta.blog.payload.PostDto;
import com.debakanta.blog.payload.PostResponce;
import com.debakanta.blog.respositories.CatagoryRepo;
import com.debakanta.blog.respositories.PostRepo;
import com.debakanta.blog.respositories.UserRespo;
import com.debakanta.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRespo userRespo;
	
	@Autowired
	private CatagoryRepo catagoryRepo;

	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer catagoryId) {
		User user = this.userRespo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User", "User Id", userId));
		Catagory catagory = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(()->new ResourceNotFoundException("Catagory", "Catagory Id", catagoryId));
		
		Post post = this.mapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCatagory(catagory);
		
		Post newPost = this.postRepo.save(post);
		
		return this.mapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		
		this.postRepo.deleteById(postId);
	}

	@Override
	public PostResponce getAllPost(Integer pageNumber,Integer pageSize) {
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		
		Page<Post> pagePost = this.postRepo.findAll(p);
		List<Post> allPosts = pagePost.getContent();
		
		List<PostDto> postDtos = allPosts.stream().map(post->this.mapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponce postResponce = new PostResponce();
		postResponce.setContent(postDtos);
		postResponce.setPageNumber(pagePost.getNumber());
		postResponce.setPageSize(pagePost.getSize());
		postResponce.setTotalElements(pagePost.getTotalElements());
		postResponce.setTotalPages(pagePost.getTotalPages());
		postResponce.setLast(pagePost.isLast());
		
		return postResponce;
	}

	@Override
	public List<PostDto> getPostByUSer(Integer userId) {
		User user = this.userRespo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User", "User id", userId));
		List<Post> posts= this.postRepo.findByUser(user);
		
		List<PostDto> postDtos = posts.stream().map(post->this.mapper.map(post, PostDto.class)).collect(Collectors.toList());
				
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByCatagory(Integer catagoryId) {
		Catagory catagory = this.catagoryRepo.findById(catagoryId)
				.orElseThrow(()->new ResourceNotFoundException("Catagory", "catagory Id", catagoryId));
		
		List<Post> posts = this.postRepo.findByCatagory(catagory);
		
		List<PostDto> postDtos = posts.stream().map(post->this.mapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByKeyword(String keyword) {
		List<Post> posts= this.postRepo.findByTitleContaining(keyword);
		
		List<PostDto> postDtos = posts.stream().map(post->this.mapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public PostDto getPostByPostId(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(()->new ResourceNotFoundException("Post", "Post Id", postId));
		
		return this.mapper.map(post, PostDto.class);
	}

}

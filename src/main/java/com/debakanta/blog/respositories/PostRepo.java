package com.debakanta.blog.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.debakanta.blog.entities.Catagory;
import com.debakanta.blog.entities.Post;
import com.debakanta.blog.entities.User;
@Repository
public interface PostRepo extends JpaRepository<Post, Integer>{
	List<Post> findByUser(User user);
	List<Post> findByCatagory(Catagory catagory);
	
	List<Post> findByTitleContaining(String title);
}

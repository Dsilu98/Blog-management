package com.debakanta.blog.services;

import com.debakanta.blog.payload.UserDto;
import java.util.List;

import org.springframework.stereotype.Service;
public interface UserService {
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	List<UserDto> getAllUsers();
	UserDto getUserById(Integer id);
	void deleteUser(Integer userId);
}

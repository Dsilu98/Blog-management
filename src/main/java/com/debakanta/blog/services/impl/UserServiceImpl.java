package com.debakanta.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.debakanta.blog.entities.User;
import com.debakanta.blog.exceptions.ResourceNotFoundException;
import com.debakanta.blog.payload.UserDto;
import com.debakanta.blog.respositories.UserRespo;
import com.debakanta.blog.services.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRespo userRespo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User saveUser = this.userRespo.save(user);
		
		return this.userToDto(saveUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user = this.userRespo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		user.setName(userDto.getName());
		user.setEmailid(userDto.getEmailid());
		user.setPassword(user.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = userRespo.save(user);
		return userToDto(updatedUser);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> userList = this.userRespo.findAll();
		if(userList.isEmpty())
			throw new ResourceNotFoundException(null, null, 0);
		List<UserDto> dtoList = userList.stream().map(x->userToDto(x)).collect(Collectors.toList());
		return dtoList;
	}
	
	@Override
	public UserDto getUserById(Integer id) {
		User getUser = this.userRespo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("User", "UserId", id));
		return userToDto(getUser);
	}
	

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRespo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		this.userRespo.delete(user);
	}
	
	public User dtoToUser(UserDto usderDto) {
		User user = this.modelMapper.map(usderDto, User.class);
//		User user = new User();
//		user.setId(usderDto.getId());
//		user.setName(usderDto.getName());
//		user.setEmailid(usderDto.getEmailid());
//		user.setAbout(usderDto.getAbout());
//		user.setPassword(usderDto.getPassword());
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto dtoUserDto = this.modelMapper.map(user, UserDto.class);
		return dtoUserDto;
	}

	
}


